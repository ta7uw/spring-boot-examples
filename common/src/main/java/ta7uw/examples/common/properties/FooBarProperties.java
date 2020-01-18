package ta7uw.examples.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "foo-bar")
public class FooBarProperties {
    private String name;
    private Integer code;
}
