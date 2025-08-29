#!/bin/bash

# Script de despliegue para AWS EC2
# Pokemon API - Spring Boot Application

set -e

echo "🚀 Iniciando despliegue de Pokemon API en EC2..."

# Variables de configuración
APP_NAME="pokemon-api"
APP_VERSION="0.0.1"
JAR_FILE="pokemon-api-${APP_VERSION}.jar"
SERVICE_NAME="pokemon-api"
USER="ubuntu"

# Colores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Función para imprimir mensajes
print_status() {
    echo -e "${GREEN}[INFO]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# Verificar si estamos en el directorio correcto
if [ ! -f "pom.xml" ]; then
    print_error "No se encontró pom.xml. Ejecuta este script desde el directorio raíz del proyecto."
    exit 1
fi

# 1. Compilar el proyecto
print_status "Compilando el proyecto..."
mvn clean package -DskipTests

if [ $? -ne 0 ]; then
    print_error "Error al compilar el proyecto"
    exit 1
fi

# 2. Verificar que el JAR se creó
if [ ! -f "target/${JAR_FILE}" ]; then
    print_error "No se encontró el archivo JAR: target/${JAR_FILE}"
    exit 1
fi

print_status "Proyecto compilado exitosamente"

# 3. Crear archivo de configuración del servicio systemd
print_status "Creando archivo de servicio systemd..."

cat > pokemon-api.service << EOF
[Unit]
Description=Pokemon API Spring Boot Application
After=network.target mysql.service

[Service]
Type=simple
User=${USER}
WorkingDirectory=/home/${USER}/${APP_NAME}
ExecStart=/usr/bin/java -jar ${JAR_FILE} --spring.profiles.active=prod
ExecReload=/bin/kill -HUP \$MAINPID
Restart=always
RestartSec=10

# Environment variables
Environment=DB_URL=jdbc:mysql://localhost:3306/PokemonApiDatabase
Environment=DB_USERNAME=root
Environment=DB_PASSWORD=your_mysql_password_here
Environment=SPRING_JPA_HIBERNATE_DDL_AUTO=none
Environment=SERVER_PORT=8080
Environment=LOG_LEVEL_ROOT=INFO
Environment=LOG_LEVEL_APP=INFO

# Security settings
NoNewPrivileges=true
PrivateTmp=true
ProtectSystem=strict
ReadWritePaths=/home/${USER}/${APP_NAME}/logs

[Install]
WantedBy=multi-user.target
EOF

# 4. Crear script de instalación en EC2
print_status "Creando script de instalación para EC2..."

cat > install-ec2.sh << 'EOF'
#!/bin/bash

# Script de instalación para EC2
# Ejecutar como usuario ubuntu

set -e

APP_NAME="pokemon-api"
APP_VERSION="0.0.1"
JAR_FILE="pokemon-api-${APP_VERSION}.jar"
SERVICE_NAME="pokemon-api"

# Colores
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m'

print_status() {
    echo -e "${GREEN}[INFO]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# 1. Actualizar sistema
print_status "Actualizando sistema..."
sudo apt update && sudo apt upgrade -y

# 2. Instalar Java 21
print_status "Instalando Java 21..."
sudo apt install -y openjdk-21-jdk

# Verificar instalación
java -version

# 3. Instalar MySQL
print_status "Instalando MySQL..."
sudo apt install -y mysql-server

# 4. Configurar MySQL
print_status "Configurando MySQL..."
sudo mysql_secure_installation

# 5. Crear base de datos y usuario
print_status "Creando base de datos..."
sudo mysql -e "CREATE DATABASE IF NOT EXISTS PokemonApiDatabase;"
sudo mysql -e "CREATE USER IF NOT EXISTS 'pokemon_user'@'localhost' IDENTIFIED BY 'your_secure_password';"
sudo mysql -e "GRANT ALL PRIVILEGES ON PokemonApiDatabase.* TO 'pokemon_user'@'localhost';"
sudo mysql -e "FLUSH PRIVILEGES;"

# 6. Crear directorio de la aplicación
print_status "Creando directorio de la aplicación..."
mkdir -p ~/${APP_NAME}/logs

# 7. Copiar archivos (asumiendo que ya están en el servidor)
print_status "Copiando archivos de la aplicación..."
# El JAR debe estar en el directorio actual
cp ${JAR_FILE} ~/${APP_NAME}/

# 8. Configurar servicio systemd
print_status "Configurando servicio systemd..."
sudo cp pokemon-api.service /etc/systemd/system/
sudo systemctl daemon-reload
sudo systemctl enable ${SERVICE_NAME}

# 9. Configurar firewall
print_status "Configurando firewall..."
sudo ufw allow 22/tcp
sudo ufw allow 80/tcp
sudo ufw allow 443/tcp
sudo ufw allow 8080/tcp
sudo ufw --force enable

# 10. Iniciar servicio
print_status "Iniciando servicio..."
sudo systemctl start ${SERVICE_NAME}

# 11. Verificar estado
print_status "Verificando estado del servicio..."
sudo systemctl status ${SERVICE_NAME}

print_status "Instalación completada!"
print_status "La aplicación está disponible en: http://$(curl -s ifconfig.me):8080"
print_status "Para ver logs: sudo journalctl -u ${SERVICE_NAME} -f"
print_status "Para reiniciar: sudo systemctl restart ${SERVICE_NAME}"
print_status "Para detener: sudo systemctl stop ${SERVICE_NAME}"

EOF

# 5. Crear archivo .env de ejemplo
print_status "Creando archivo .env de ejemplo..."

cat > .env.example << EOF
# Configuración de Base de Datos
DB_URL=jdbc:mysql://localhost:3306/PokemonApiDatabase
DB_USERNAME=pokemon_user
DB_PASSWORD=your_secure_password

# Configuración de JPA
SPRING_JPA_HIBERNATE_DDL_AUTO=none
SHOW_SQL=false
FORMAT_SQL=false

# Configuración de Pool de Conexiones
DB_MAX_POOL_SIZE=10
DB_MIN_IDLE=5
DB_CONNECTION_TIMEOUT=30000

# Configuración del Servidor
SERVER_PORT=8080
SERVER_ADDRESS=0.0.0.0

# Configuración de Logging
LOG_LEVEL_ROOT=INFO
LOG_LEVEL_APP=INFO
LOG_LEVEL_WEB=INFO
LOG_LEVEL_SQL=WARN
EOF

# 6. Crear Dockerfile optimizado para producción
print_status "Creando Dockerfile optimizado para producción..."

cat > Dockerfile.prod << 'EOF'
# Multi-stage build para producción
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:21.0.3_9-jre-alpine

RUN addgroup -g 1001 -S appgroup && \
    adduser -u 1001 -S appuser -G appgroup

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

RUN chown -R appuser:appgroup /app
USER appuser

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
EOF

# 7. Crear docker-compose para producción
print_status "Creando docker-compose para producción..."

cat > docker-compose.prod.yml << 'EOF'
version: '3.8'

services:
  pokemon-api:
    build:
      context: .
      dockerfile: Dockerfile.prod
    container_name: pokemon-api-prod
    restart: unless-stopped
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=prod
      - DB_URL=jdbc:mysql://mysql-prod:3306/PokemonApiDatabase
      - DB_USERNAME=pokemon_user
      - DB_PASSWORD=${DB_PASSWORD}
      - SPRING_JPA_HIBERNATE_DDL_AUTO=none
      - SERVER_PORT=8080
      - LOG_LEVEL_ROOT=INFO
    depends_on:
      - mysql-prod
    networks:
      - pokemon-network
    volumes:
      - ./logs:/app/logs

  mysql-prod:
    image: mysql:8.0
    container_name: mysql-prod
    restart: unless-stopped
    environment:
      MYSQL_ROOT_PASSWORD: ${MYSQL_ROOT_PASSWORD}
      MYSQL_DATABASE: PokemonApiDatabase
      MYSQL_USER: pokemon_user
      MYSQL_PASSWORD: ${DB_PASSWORD}
    ports:
      - "3306:3306"
    volumes:
      - mysql-data:/var/lib/mysql
      - ./scripts/mysql:/docker-entrypoint-initdb.d
    networks:
      - pokemon-network
    command: --default-authentication-plugin=mysql_native_password

networks:
  pokemon-network:
    driver: bridge

volumes:
  mysql-data:
EOF

# 8. Crear script de monitoreo
print_status "Creando script de monitoreo..."

cat > monitor.sh << 'EOF'
#!/bin/bash

# Script de monitoreo para Pokemon API

SERVICE_NAME="pokemon-api"
APP_URL="http://localhost:8080"

echo "=== Estado del Servicio ==="
sudo systemctl status ${SERVICE_NAME} --no-pager

echo -e "\n=== Uso de Recursos ==="
echo "CPU y Memoria:"
ps aux | grep java | grep -v grep

echo -e "\n=== Logs Recientes ==="
sudo journalctl -u ${SERVICE_NAME} --no-pager -n 20

echo -e "\n=== Verificación de Salud ==="
if curl -f -s ${APP_URL}/actuator/health > /dev/null; then
    echo "✅ La aplicación está respondiendo correctamente"
else
    echo "❌ La aplicación no está respondiendo"
fi

echo -e "\n=== Espacio en Disco ==="
df -h

echo -e "\n=== Memoria Disponible ==="
free -h
EOF

chmod +x monitor.sh

print_status "✅ Archivos de despliegue creados exitosamente!"

echo -e "\n${YELLOW}📋 INSTRUCCIONES DE DESPLIEGUE:${NC}"
echo "1. Sube los siguientes archivos a tu instancia EC2:"
echo "   - target/${JAR_FILE}"
echo "   - pokemon-api.service"
echo "   - install-ec2.sh"
echo "   - .env.example"
echo ""
echo "2. En tu instancia EC2, ejecuta:"
echo "   chmod +x install-ec2.sh"
echo "   ./install-ec2.sh"
echo ""
echo "3. Configura las variables de entorno en /etc/systemd/system/pokemon-api.service"
echo ""
echo "4. Para monitorear:"
echo "   chmod +x monitor.sh"
echo "   ./monitor.sh"
echo ""
echo "${GREEN}🎉 ¡Tu proyecto está listo para desplegar en EC2!${NC}"
