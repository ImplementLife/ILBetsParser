#!/bin/bash

KAFKA_BROKER="localhost:9092"
TOPIC_NAME="bots"

kafka-topics.sh --bootstrap-server $KAFKA_BROKER --create --topic $TOPIC_NAME --replication-factor 1 --partitions 1
echo "Topic $TOPIC_NAME created successfully."