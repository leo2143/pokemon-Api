# 🚀 Guía de Despliegue - Pokémon API en AWS EC2 con Docker

Esta guía te ayudará a desplegar tu aplicación Pokémon API en una instancia EC2 de AWS usando Docker.

## 📋 Prerrequisitos

- Una instancia EC2 de AWS (recomendado: Ubuntu 22.04 LTS)
- Acceso SSH a la instancia
- Un par de claves SSH configurado
- Grupo de seguridad configurado con puertos 22, 80, 443, 8080 abiertos

## 🛠️ Preparación Local

### 1. Generar archivos de despliegue

Ejecuta el script de preparación:

```bash
chmod +x deploy-docker-ec2.sh
./deploy-docker-ec2.sh
```

Este script creará:
- `docker-compose.prod.yml` - Configuración de Docker Compose para producción
- `Dockerfile.prod` - Dockerfile optimizado para producción
- `nginx/nginx.conf` - Configuración de Nginx como proxy reverso
- `.env` - Variables de entorno (¡cambia las contraseñas!)
- `install-docker-ec2.sh` - Script de instalación para EC2
- `monitor-docker.sh` - Script de monitoreo
- `backup.sh` - Script de backup

### 2. Configurar variables de entorno

Edita el archivo `.env` y cambia las contraseñas:

```bash
# Configuración de Base de Datos
MYSQL_ROOT_PASSWORD=TuContraseñaSegura123!
DB_PASSWORD=TuContraseñaDBSegura123!

# ... resto de configuración
```

## 🚀 Despliegue en EC2

### Opción 1: Despliegue Manual

#### 1. Conectar a tu instancia EC2

```bash
ssh -i tu-clave.pem ubuntu@tu-ip-ec2
```

#### 2. Subir archivos al servidor

Desde tu máquina local:

```bash
# Crear un archivo tar con todo el proyecto
tar -czf pokemon-api.tar.gz \
  src/ pom.xml \
  docker-compose.prod.yml \
  Dockerfile.prod \
  nginx/ \
  .env \
  install-docker-ec2.sh \
  monitor-docker.sh \
  backup.sh \
  scripts/

# Subir a EC2
scp -i tu-clave.pem pokemon-api.tar.gz ubuntu@tu-ip-ec2:~/
```

#### 3. En la instancia EC2

```bash
# Descomprimir archivos
tar -xzf pokemon-api.tar.gz

# Dar permisos de ejecución
chmod +x install-docker-ec2.sh monitor-docker.sh backup.sh

# Ejecutar instalación
./install-docker-ec2.sh
```

### Opción 2: Despliegue con Git

#### 1. Configurar Git en EC2

```bash
# En tu instancia EC2
sudo apt update
sudo apt install -y git

# Clonar tu repositorio
git clone https://github.com/tu-usuario/pokemon-api.git
cd pokemon-api

# Copiar archivos de configuración
cp .env.example .env
# Editar .env con las contraseñas correctas
nano .env
```

#### 2. Ejecutar instalación

```bash
chmod +x install-docker-ec2.sh
./install-docker-ec2.sh
```

## 🔧 Configuración Post-Despliegue

### 1. Verificar estado de los servicios

```bash
# Ver estado de contenedores
docker-compose -f docker-compose.prod.yml ps

# Ver logs
docker-compose -f docker-compose.prod.yml logs -f

# Ejecutar monitoreo
./monitor-docker.sh
```

### 2. Configurar dominio (opcional)

Si tienes un dominio, configura DNS para apuntar a tu IP de EC2.

### 3. Configurar SSL con Let's Encrypt (opcional)

```bash
# Instalar Certbot
sudo apt install -y certbot python3-certbot-nginx

# Obtener certificado
sudo certbot --nginx -d tu-dominio.com

# Configurar renovación automática
sudo crontab -e
# Agregar: 0 12 * * * /usr/bin/certbot renew --quiet
```

## 📊 Monitoreo y Mantenimiento

### Comandos útiles

```bash
# Ver logs en tiempo real
docker-compose -f docker-compose.prod.yml logs -f pokemon-api

# Reiniciar servicios
docker-compose -f docker-compose.prod.yml restart

# Actualizar aplicación
docker-compose -f docker-compose.prod.yml pull
docker-compose -f docker-compose.prod.yml up -d

# Ver uso de recursos
docker stats

# Hacer backup
./backup.sh

# Verificar salud de la aplicación
curl http://localhost:8080/actuator/health
```

### Scripts de monitoreo

```bash
# Monitoreo completo
./monitor-docker.sh

# Backup automático (configurar en crontab)
0 2 * * * /home/ubuntu/pokemon-api/backup.sh
```

## 🔒 Seguridad

### 1. Firewall

El script configura automáticamente UFW con:
- Puerto 22 (SSH)
- Puerto 80 (HTTP)
- Puerto 443 (HTTPS)
- Puerto 8080 (Aplicación)

### 2. Variables de entorno

- Nunca subas el archivo `.env` a Git
- Usa contraseñas fuertes
- Rota las contraseñas regularmente

### 3. Actualizaciones

```bash
# Actualizar sistema
sudo apt update && sudo apt upgrade -y

# Actualizar Docker
sudo apt install -y docker-ce docker-ce-cli containerd.io
```

## 🚨 Troubleshooting

### Problemas comunes

#### 1. La aplicación no responde

```bash
# Verificar logs
docker-compose -f docker-compose.prod.yml logs pokemon-api

# Verificar estado de contenedores
docker-compose -f docker-compose.prod.yml ps

# Reiniciar servicios
docker-compose -f docker-compose.prod.yml restart
```

#### 2. Problemas de base de datos

```bash
# Verificar logs de MySQL
docker-compose -f docker-compose.prod.yml logs mysql-prod

# Conectar a MySQL
docker exec -it mysql-prod mysql -u root -p
```

#### 3. Problemas de memoria

```bash
# Ver uso de memoria
free -h
docker stats

# Limpiar recursos Docker
docker system prune -a
```

#### 4. Problemas de puertos

```bash
# Verificar puertos en uso
sudo netstat -tulpn | grep :8080

# Verificar firewall
sudo ufw status
```

## 📈 Escalabilidad

### Para escalar horizontalmente:

1. **Usar un load balancer** (AWS ALB)
2. **Configurar múltiples instancias** EC2
3. **Usar RDS** para la base de datos
4. **Implementar cache** con Redis

### Configuración recomendada para producción:

- **Instancia EC2**: t3.medium o superior
- **Almacenamiento**: 20GB mínimo
- **Base de datos**: RDS MySQL (recomendado)
- **Load Balancer**: AWS Application Load Balancer
- **CDN**: CloudFront para contenido estático

## 🔄 Actualizaciones

### Proceso de actualización

```bash
# 1. Hacer backup
./backup.sh

# 2. Detener servicios
docker-compose -f docker-compose.prod.yml down

# 3. Actualizar código
git pull origin main

# 4. Reconstruir y reiniciar
docker-compose -f docker-compose.prod.yml build --no-cache
docker-compose -f docker-compose.prod.yml up -d

# 5. Verificar
./monitor-docker.sh
```

## 📞 Soporte

Si encuentras problemas:

1. Revisa los logs: `docker-compose -f docker-compose.prod.yml logs`
2. Ejecuta el script de monitoreo: `./monitor-docker.sh`
3. Verifica la configuración de red y firewall
4. Consulta la documentación de Docker y Spring Boot

---

## 🎉 ¡Listo!

Tu aplicación Pokémon API está ahora desplegada en AWS EC2 con Docker. 

**URL de acceso**: `http://tu-ip-ec2:8080`

**Documentación de la API**: `http://tu-ip-ec2:8080/swagger-ui.html`

¡Disfruta de tu aplicación en producción! 🚀
