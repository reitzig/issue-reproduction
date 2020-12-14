package repro.converters;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import repro.config.Bar;

import javax.validation.constraints.Pattern;

// Dev note: Some ways of setting properties require converters for string, not integers
// (e.g. @SpringBootTest (properties)).
@Component
@ConfigurationPropertiesBinding
public class DelegatingBarConverter implements Converter<String, Bar> {
    private final Converter<Integer, Bar> fromIntConverter;

    public DelegatingBarConverter(@NonNull Converter<Integer, Bar> fromIntConverter) {
        this.fromIntConverter = fromIntConverter;
    }

    @Override
    public Bar convert(@NonNull @Pattern(regexp = "^\\d+$") String propertyString) {
        var value = Integer.parseInt(propertyString);
        return fromIntConverter.convert(value);
    }
}
