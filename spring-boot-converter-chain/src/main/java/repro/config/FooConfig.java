package repro.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
@ConfigurationProperties(prefix = "foo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FooConfig {

    @NotNull
    @Setter(AccessLevel.PACKAGE)
    private Bar bar;

}
