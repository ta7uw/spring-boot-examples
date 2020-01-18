package ta7uw.examples.batch.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ta7uw.examples.batch.component.SampleProducer;

@Component
@Slf4j
@RequiredArgsConstructor
@ConditionalOnExpression("'${service.hostname}'=='${batch.sample-scheduler.hostname}'")
public class SampleScheduler {

    private final SampleProducer sampleProducer;

    @Scheduled(cron = "${batch.sample-scheduler.cron}")
    public void executeSampleTask() throws Exception {
        log.info("Sample task started");
        sampleProducer.send("key", "data");
        sampleProducer.flush();
    }
}
