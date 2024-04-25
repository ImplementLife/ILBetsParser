@echo off

docker-compose build
REM docker-compose build ui-server bots
REM docker-compose build ui-server
docker-compose up -d