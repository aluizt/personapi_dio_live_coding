package one.digitalinnovation.personapi.config.deserializer;

import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DeserializerModule extends SimpleModule {
    private static final long serialVersionUID = -3252402520766665670L;

    public DeserializerModule() {
        addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        addDeserializer(LocalDate.class, new LocalDateDeserializer());
    }
}
