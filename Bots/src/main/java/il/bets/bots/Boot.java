package il.bets.bots;

import il.bets.bots.services.Orchestrator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySources({
    @PropertySource("classpath:application.properties"),
    @PropertySource("classpath:application-docker.properties")
})
public class Boot {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Boot.class);
        Orchestrator orchestrator = context.getBean(Orchestrator.class);
        orchestrator.beginGenerateReports();
    }
}
