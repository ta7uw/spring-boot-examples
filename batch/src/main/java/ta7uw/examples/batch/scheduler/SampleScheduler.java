package ta7uw.examples.batch.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ConditionalOnExpression("'${service.hostname}'=='${batch.sample-scheduler.hostname}'")
public class SampleScheduler {

    @Scheduled(cron = "${batch.sample-scheduler.cron}")
    public void executeSampleTask() {
        log.info("Execute sample task");
    }
}
