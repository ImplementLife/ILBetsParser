FROM wurstmeister/kafka:latest

ENV KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://kafka:9092 \
    KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 \
    KAFKA_LISTENER_SECURITY_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT \
    KAFKA_INTER_BROKER_LISTENER_NAME=PLAINTEXT \
    KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181

COPY Kafka/create_topic.sh /app/create_topic.sh
#CMD ["create_topic.sh"]
#CMD ["kafka-server-start.sh", "/opt/kafka/config/server.properties"]