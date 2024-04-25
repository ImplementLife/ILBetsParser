#!/bin/bash

KAFKA_BROKER="localhost:9092"
TOPIC_NAME="quickstart"

# Check if the topic already exists
existing_topics=$(kafka-topics.sh --bootstrap-server $KAFKA_BROKER --list)

if [[ $existing_topics =~ $TOPIC_NAME ]]; then
    echo "Topic $TOPIC_NAME already exists."
else
    # Create the topic
    kafka-topics.sh --bootstrap-server $KAFKA_BROKER --create --topic $TOPIC_NAME --replication-factor 1 --partitions 1
    echo "Topic $TOPIC_NAME created successfully."
fi