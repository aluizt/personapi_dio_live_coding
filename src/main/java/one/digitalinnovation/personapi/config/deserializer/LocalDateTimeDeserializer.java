package one.digitalinnovation.personapi.config.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import one.digitalinnovation.personapi.exception.GenericException;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
    private static final long serialVersionUID = 542348723505928517L;

    public LocalDateTimeDeserializer() {
        this(null);
    }

    public LocalDateTimeDeserializer(Class<LocalDateTime> t) {
        super(t);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        try {
            return LocalDateTime.parse(p.getText(), DateTimeFormatter.ISO_DATE_TIME);
        } catch (Exception error) {
            throw new GenericException(p.getCurrentName(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
