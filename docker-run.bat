@echo off

REM docker-compose build
REM docker-compose build ui-server bots
REM docker-compose build ui-server

cd Server
mvn clean package
cd ..

cd Bots
mvn clean package
cd ..

docker-compose up -d