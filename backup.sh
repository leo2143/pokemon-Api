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
