#!/bin/bash

# Script de despliegue Docker para AWS EC2
# Pokemon API - Spring Boot Application

set -e

echo "🐳 Iniciando despliegue Docker de Pokemon API en EC2..."

# Variables de configuración
APP_NAME="pokemon-api"
DOCKER_IMAGE="pokemon-api"
DOCKER_TAG="latest"
COMPOSE_FILE="docker-compose.prod.yml"

# Colores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
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

print_step() {
    echo -e "${BLUE}[STEP]${NC} $1"
}

# Verificar si estamos en el directorio correcto
if [ ! -f "pom.xml" ]; then
    print_error "No se encontró pom.xml. Ejecuta este script desde el directorio raíz del proyecto."
    exit 1
fi

# 1. Crear archivo .env para producción
print_step "Creando archivo .env para producción..."

cat > .env << 'EOF'
# Configuración de Base de Datos
MYSQL_ROOT_PASSWORD=YourSecureRootPassword123!
DB_PASSWORD=YourSecureDBPassword123!

# Configuración de la Aplicación
SPRING_PROFILES_ACTIVE=prod
SERVER_PORT=8080

# Configuración de JPA
SPRING_JPA_HIBERNATE_DDL_AUTO=none
SHOW_SQL=false
FORMAT_SQL=false

# Configuración de Pool de Conexiones
DB_MAX_POOL_SIZE=10
DB_MIN_IDLE=5
DB_CONNECTION_TIMEOUT=30000

# Configuración del Servidor
SERVER_ADDRESS=0.0.0.0

# Configuración de Logging
LOG_LEVEL_ROOT=INFO
LOG_LEVEL_APP=INFO
LOG_LEVEL_WEB=INFO
LOG_LEVEL_SQL=WARN
EOF

print_warning "⚠️  IMPORTANTE: Cambia las contraseñas en el archivo .env antes de desplegar!"

# 2. Crear docker-compose optimizado para producción
print_step "Creando docker-compose optimizado para producción..."

cat > docker-compose.prod.yml << 'EOF'
version: '3.8'

services:
  pokemon-api:
    build:
      context: .
      dockerfile: Dockerfile.prod
    image: ${DOCKER_IMAGE}:${DOCKER_TAG}
    container_name: pokemon-api-prod
    restart: unless-stopped
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=prod
      - DB_URL=jdbc:mysql://mysql-prod:3306/PokemonApiDatabase?useSSL=false&allowPublicKeyRetrieval=true
      - DB_USERNAME=pokemon_user
      - DB_PASSWORD=${DB_PASSWORD}
      - SPRING_JPA_HIBERNATE_DDL_AUTO=none
      - SERVER_PORT=8080
      - LOG_LEVEL_ROOT=INFO
      - SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.MySQL8Dialect
    depends_on:
      mysql-prod:
        condition: service_healthy
    networks:
      - pokemon-network
    volumes:
      - ./logs:/app/logs
    healthcheck:
      test: ["CMD", "wget", "--no-verbose", "--tries=1", "--spider", "http://localhost:8080/actuator/health"]
      interval: 30s
      timeout: 10s
      retries: 3
      start_period: 60s

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
    command: --default-authentication-plugin=mysql_native_password --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
    healthcheck:
      test: ["CMD", "mysqladmin", "ping", "-h", "localhost", "-u", "root", "-p${MYSQL_ROOT_PASSWORD}"]
      interval: 10s
      timeout: 5s
      retries: 5
      start_period: 30s

  nginx:
    image: nginx:alpine
    container_name: nginx-proxy
    restart: unless-stopped
    ports:
      - "80:80"
      - "443:443"
    volumes:
      - ./nginx/nginx.conf:/etc/nginx/nginx.conf:ro
      - ./nginx/ssl:/etc/nginx/ssl:ro
    depends_on:
      - pokemon-api
    networks:
      - pokemon-network

networks:
  pokemon-network:
    driver: bridge

volumes:
  mysql-data:
    driver: local
EOF

# 3. Crear Dockerfile optimizado para producción
print_step "Creando Dockerfile optimizado para producción..."

cat > Dockerfile.prod << 'EOF'
# Multi-stage build para producción
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar archivos de dependencias primero para mejor cache
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar código fuente
COPY src ./src

# Compilar la aplicación
RUN mvn clean package -DskipTests -B

# Runtime stage - usar JRE más ligero
FROM eclipse-temurin:21.0.3_9-jre-alpine

# Instalar herramientas necesarias
RUN apk add --no-cache wget curl

# Crear usuario no-root para seguridad
RUN addgroup -g 1001 -S appgroup && \
    adduser -u 1001 -S appuser -G appgroup

WORKDIR /app

# Copiar JAR compilado
COPY --from=build /app/target/*.jar app.jar

# Cambiar permisos
RUN chown -R appuser:appgroup /app

# Cambiar a usuario no-root
USER appuser

# Exponer puerto
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8080/actuator/health || exit 1

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]
EOF

# 4. Crear configuración de Nginx
print_step "Creando configuración de Nginx..."

mkdir -p nginx

cat > nginx/nginx.conf << 'EOF'
events {
    worker_connections 1024;
}

http {
    upstream pokemon_api {
        server pokemon-api:8080;
    }

    server {
        listen 80;
        server_name _;

        location / {
            proxy_pass http://pokemon_api;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_set_header X-Forwarded-Proto $scheme;
            
            # Configuración para WebSocket si es necesario
            proxy_http_version 1.1;
            proxy_set_header Upgrade $http_upgrade;
            proxy_set_header Connection "upgrade";
        }

        # Configuración para archivos estáticos
        location /static/ {
            alias /var/www/static/;
            expires 1y;
            add_header Cache-Control "public, immutable";
        }

        # Configuración de seguridad
        add_header X-Frame-Options "SAMEORIGIN" always;
        add_header X-Content-Type-Options "nosniff" always;
        add_header X-XSS-Protection "1; mode=block" always;
        add_header Referrer-Policy "strict-origin-when-cross-origin" always;
    }
}
EOF

# 5. Crear script de instalación para EC2
print_step "Creando script de instalación para EC2..."

cat > install-docker-ec2.sh << 'EOF'
#!/bin/bash

# Script de instalación Docker para EC2
# Ejecutar como usuario ubuntu

set -e

# Colores
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
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

print_step() {
    echo -e "${BLUE}[STEP]${NC} $1"
}

# 1. Actualizar sistema
print_step "Actualizando sistema..."
sudo apt update && sudo apt upgrade -y

# 2. Instalar dependencias
print_step "Instalando dependencias..."
sudo apt install -y apt-transport-https ca-certificates curl gnupg lsb-release

# 3. Agregar repositorio oficial de Docker
print_step "Configurando repositorio de Docker..."
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

# 4. Instalar Docker
print_step "Instalando Docker..."
sudo apt update
sudo apt install -y docker-ce docker-ce-cli containerd.io docker-compose-plugin

# 5. Agregar usuario ubuntu al grupo docker
print_step "Configurando permisos de Docker..."
sudo usermod -aG docker $USER

# 6. Instalar Docker Compose standalone (por si acaso)
print_step "Instalando Docker Compose..."
sudo curl -L "https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

# 7. Configurar firewall
print_step "Configurando firewall..."
sudo ufw allow 22/tcp
sudo ufw allow 80/tcp
sudo ufw allow 443/tcp
sudo ufw allow 8080/tcp
sudo ufw --force enable

# 8. Crear directorios necesarios
print_step "Creando directorios..."
mkdir -p ~/pokemon-api/logs
mkdir -p ~/pokemon-api/nginx/ssl

# 9. Configurar variables de entorno
print_step "Configurando variables de entorno..."
if [ ! -f .env ]; then
    print_warning "Archivo .env no encontrado. Crea uno con las variables necesarias."
fi

# 10. Construir y ejecutar contenedores
print_step "Construyendo y ejecutando contenedores..."
docker-compose -f docker-compose.prod.yml build --no-cache
docker-compose -f docker-compose.prod.yml up -d

# 11. Verificar estado
print_step "Verificando estado de los contenedores..."
sleep 30
docker-compose -f docker-compose.prod.yml ps

# 12. Verificar logs
print_step "Verificando logs..."
docker-compose -f docker-compose.prod.yml logs --tail=20

print_status "✅ Instalación completada!"
print_status "La aplicación está disponible en: http://$(curl -s ifconfig.me)"
print_status "Para ver logs: docker-compose -f docker-compose.prod.yml logs -f"
print_status "Para reiniciar: docker-compose -f docker-compose.prod.yml restart"
print_status "Para detener: docker-compose -f docker-compose.prod.yml down"
print_status "Para actualizar: docker-compose -f docker-compose.prod.yml pull && docker-compose -f docker-compose.prod.yml up -d"

EOF

chmod +x install-docker-ec2.sh

# 6. Crear script de monitoreo Docker
print_step "Creando script de monitoreo Docker..."

cat > monitor-docker.sh << 'EOF'
#!/bin/bash

# Script de monitoreo Docker para Pokemon API

COMPOSE_FILE="docker-compose.prod.yml"

echo "=== Estado de los Contenedores ==="
docker-compose -f ${COMPOSE_FILE} ps

echo -e "\n=== Uso de Recursos ==="
docker stats --no-stream

echo -e "\n=== Logs Recientes ==="
docker-compose -f ${COMPOSE_FILE} logs --tail=20

echo -e "\n=== Verificación de Salud ==="
if curl -f -s http://localhost:8080/actuator/health > /dev/null; then
    echo "✅ La aplicación está respondiendo correctamente"
else
    echo "❌ La aplicación no está respondiendo"
fi

echo -e "\n=== Espacio en Disco ==="
df -h

echo -e "\n=== Volúmenes Docker ==="
docker volume ls

echo -e "\n=== Imágenes Docker ==="
docker images | grep pokemon-api
EOF

chmod +x monitor-docker.sh

# 7. Crear script de backup
print_step "Creando script de backup..."

cat > backup.sh << 'EOF'
#!/bin/bash

# Script de backup para Pokemon API

BACKUP_DIR="/home/ubuntu/backups"
DATE=$(date +%Y%m%d_%H%M%S)
BACKUP_NAME="pokemon-api-backup-${DATE}"

mkdir -p ${BACKUP_DIR}

echo "Creando backup: ${BACKUP_NAME}"

# Backup de la base de datos
docker exec mysql-prod mysqldump -u root -p${MYSQL_ROOT_PASSWORD} PokemonApiDatabase > ${BACKUP_DIR}/${BACKUP_NAME}.sql

# Backup de logs
tar -czf ${BACKUP_DIR}/${BACKUP_NAME}-logs.tar.gz logs/

# Backup de configuración
tar -czf ${BACKUP_DIR}/${BACKUP_NAME}-config.tar.gz .env docker-compose.prod.yml nginx/

echo "Backup completado: ${BACKUP_DIR}/${BACKUP_NAME}*"
EOF

chmod +x backup.sh

print_status "✅ Archivos de despliegue Docker creados exitosamente!"

echo -e "\n${YELLOW}📋 INSTRUCCIONES DE DESPLIEGUE DOCKER:${NC}"
echo ""
echo "1. Sube los siguientes archivos a tu instancia EC2:"
echo "   - Todo el proyecto (incluyendo src/, pom.xml, etc.)"
echo "   - .env (configura las contraseñas)"
echo "   - docker-compose.prod.yml"
echo "   - Dockerfile.prod"
echo "   - nginx/nginx.conf"
echo "   - install-docker-ec2.sh"
echo "   - monitor-docker.sh"
echo "   - backup.sh"
echo ""
echo "2. En tu instancia EC2, ejecuta:"
echo "   chmod +x install-docker-ec2.sh"
echo "   ./install-docker-ec2.sh"
echo ""
echo "3. Para monitorear:"
echo "   ./monitor-docker.sh"
echo ""
echo "4. Para hacer backup:"
echo "   ./backup.sh"
echo ""
echo "5. Comandos útiles:"
echo "   - Ver logs: docker-compose -f docker-compose.prod.yml logs -f"
echo "   - Reiniciar: docker-compose -f docker-compose.prod.yml restart"
echo "   - Actualizar: docker-compose -f docker-compose.prod.yml pull && docker-compose -f docker-compose.prod.yml up -d"
echo "   - Detener: docker-compose -f docker-compose.prod.yml down"
echo ""
echo "${GREEN}🎉 ¡Tu proyecto está listo para desplegar en EC2 con Docker!${NC}"
