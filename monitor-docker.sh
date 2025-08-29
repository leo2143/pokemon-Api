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
