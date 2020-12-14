package repro.converters;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import repro.config.Bar;

@Component
@ConfigurationPropertiesBinding
@Profile("!local & !test") // aka production
public class ProductionBarConverter implements Converter<Integer, Bar> {
    @Override
    public Bar convert(@NonNull Integer value) {
        return new Bar(value);
    }
}
