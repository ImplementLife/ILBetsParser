@echo off

TOPIC_NAME=quickstart

docker-compose exec kafka kafka-topics.sh --bootstrap-server kafka:9092 --create --topic %TOPIC_NAME% --partitions 1 --replication-factor 1
docker-compose exec kafka kafka-topics.sh --bootstrap-server=localhost:9092 --list

docker-compose exec kafka kafka-console-consumer.sh --bootstrap-server=localhost:9092 --topic bots
docker-compose exec kafka kafka-console-producer.sh --broker-list localhost:9092 --topic quickstart --property "parse.key=true" --property "key.separator=:"

docker-compose exec kafka kafka-topics.sh --describe --topic bots --bootstrap-server localhost:9092