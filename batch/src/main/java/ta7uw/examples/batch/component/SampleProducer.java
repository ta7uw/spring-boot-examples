package ta7uw.examples.batch.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
@RequiredArgsConstructor
public class SampleProducer {

    @Value("${service.kafka.sample.topic}")
    private String topic;

    private final KafkaTemplate<String, String> template;

    public ListenableFuture<SendResult<String, String>> send(String key, String data) {
        return template.send(topic, key, data);
    }

    public void flush() {
        template.flush();
    }
}
