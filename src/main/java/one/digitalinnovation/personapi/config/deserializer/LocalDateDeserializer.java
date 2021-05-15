package one.digitalinnovation.personapi.config.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import one.digitalinnovation.personapi.exception.GenericException;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {
    private static final long serialVersionUID = 2151294417387550911L;

    public LocalDateDeserializer() {
        this(null);
    }

    public LocalDateDeserializer(Class<LocalDateTime> t) {
        super(t);
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        try {
            return LocalDate.parse(p.getText(), DateTimeFormatter.ISO_DATE);
        } catch (Exception error) {
            throw new GenericException(p.getCurrentName(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
