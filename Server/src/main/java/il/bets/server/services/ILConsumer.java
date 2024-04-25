package il.bets.server.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ILConsumer {
    @KafkaListener(topics = "${il.kafka.topic}")
    public void listenTopic(ConsumerRecord<String, String> record) {
        System.out.println(record.key() + " : " + record.value());
    }
}
