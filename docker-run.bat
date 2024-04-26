@echo off

REM docker-compose build
REM docker-compose build ui-server bots
REM docker-compose build ui-server
call mvn clean package -P docker-run
call docker-compose up -d --build