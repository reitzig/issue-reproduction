package repro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.test.context.ActiveProfiles;
import repro.config.Bar;
import repro.config.FooConfig;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = { "foo.bar=3" }
)
@ActiveProfiles("test")
public class WithTestPropertiesAnnotationIT {
    @Autowired
    FooConfig fooConfig;

    @SpyBean
    Converter<String, Bar> stringConverter;

    @Test
    void should_read_config_value_from_annotation() {
        assertThat(fooConfig.getBar().getValue()).isEqualTo(6);
        verify(stringConverter).convert(any()); // curious difference, but well
    }
}
