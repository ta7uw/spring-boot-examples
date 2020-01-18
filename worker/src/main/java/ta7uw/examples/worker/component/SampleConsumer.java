package ta7uw.examples.worker.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SampleConsumer {

    @KafkaListener(topics = "${service.kafka.sample.topic}")
    public void consume(String message) {
        log.info(message);
    }
}
