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
