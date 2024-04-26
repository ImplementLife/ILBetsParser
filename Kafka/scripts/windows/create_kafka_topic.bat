REM @echo off
cd ../../../
set KAFKA_BROKER=localhost:29092
set TOPIC_NAME=bots

docker-compose exec kafka kafka-topics.sh --bootstrap-server %KAFKA_BROKER% --create --topic %TOPIC_NAME% --partitions 1 --replication-factor 1