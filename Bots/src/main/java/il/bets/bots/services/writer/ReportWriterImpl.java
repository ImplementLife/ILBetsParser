package il.bets.bots.services.writer;

import il.bets.bots.dto.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportWriterImpl implements ReportWriter {
    @Override
    public void write(List<Report> parseReports) {
        for (Report parseReport : parseReports) {
            System.out.println(parseReport);
        }
    }

    @Override
    public boolean isAvailable() {
        return true;
    }
}
