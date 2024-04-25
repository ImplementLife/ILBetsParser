package il.bets.bots.services;

import il.bets.bots.dto.Report;
import il.bets.bots.services.writer.ReportWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class Orchestrator {
    @Autowired
    private List<ReportWriter> reportWriter;

    @Value("${il.threads.count}")
    private int threadsCount;
    @Value("${il.threads.period}")
    private long threadsPeriod;
    @Value("#{'${il.sports.filter}'.split(',')}")
    private List<String> sportsFilter;

    private ScheduledExecutorService executor;

    @PostConstruct
    private void postConstruct() {
        executor = Executors.newScheduledThreadPool(threadsCount);
    }

    public void beginGenerateReports() {
        for (String sportName : sportsFilter) {
            executor.scheduleAtFixedRate(() -> {
                try {
                    String parserName = sportName;
                    String threadName = Thread.currentThread().getName();
                    System.out.println("Thread " + threadName + ": start " + parserName);
                    List<Report> parseReports = new ArrayList<>();
                    parseReports.add(new Report(parserName));

                    Thread.sleep(5000);

                    System.out.println("Thread " + threadName + ": " + parserName + " reporting:");
                    for (ReportWriter writer : reportWriter) {
                        if (writer.isAvailable()) {
                            writer.write(parseReports);
                        }
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }, 0, threadsPeriod, TimeUnit.SECONDS);
        }
    }
}

