package il.bets.bots.services.writer;

import il.bets.bots.dto.Report;

import java.util.List;

public interface ReportWriter {
    void write(List<Report> parseReports);
    boolean isAvailable();
}
