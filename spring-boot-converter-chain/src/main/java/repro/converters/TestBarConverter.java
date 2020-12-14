package repro.converters;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import repro.config.Bar;

@Configuration
@ConfigurationPropertiesBinding
@Profile("local | test")
public class TestBarConverter implements Converter<Integer, Bar> {
    @Override
    public Bar convert(@NonNull Integer value) {
        return new Bar(2 * value);
    }
}
