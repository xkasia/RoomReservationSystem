package pl.hit.system.mvc.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@ReadingConverter
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

    @Override
    public LocalDateTime convert(String s) {
        if (s == null) {
            return null;
        }
        System.out.println("Tekst do sparsowania na datę: " + s);

        LocalDateTime dateTime = LocalDateTime.parse(s);
        return dateTime;
    }
}
