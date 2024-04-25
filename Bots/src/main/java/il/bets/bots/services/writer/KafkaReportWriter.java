package il.bets.bots.services.writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import il.bets.bots.dto.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaReportWriter implements ReportWriter {
    @Autowired(required = false)
    private KafkaTemplate<String, String> template;

    @Value("${il.kafka.topic}")
    private String topic;

    @Override
    public void write(List<Report> parseReports) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(parseReports);
            template.send(topic, "key_id", json);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAvailable() {
        return template != null;
    }
}
