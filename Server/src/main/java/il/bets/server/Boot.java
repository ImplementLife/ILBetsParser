package il.bets.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class Boot {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Boot.class, args);
    }
}