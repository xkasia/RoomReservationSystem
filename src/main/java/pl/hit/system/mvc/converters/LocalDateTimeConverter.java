package pl.hit.system.mvc.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
@ReadingConverter
public class LocalDateTimeConverter implements Converter<String, LocalDateTime>, AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public LocalDateTime convert(String s) {
        if (s == null) {
            return null;
        }
        System.out.println("Tekst do sparsowania na datę: " + s);

        LocalDateTime dateTime = LocalDateTime.parse(s);
        return dateTime;
    }

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime ldt) {
        return Timestamp.valueOf(ldt);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp ts) {
        if(ts!=null){
            return ts.toLocalDateTime();
        }
        return null;
    }
}
