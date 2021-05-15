package one.digitalinnovation.personapi.config.serializer;

import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class SerializerModule extends SimpleModule {

  private static final long serialVersionUID = -4179854705147548787L;

  public SerializerModule() {
    addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
    addSerializer(LocalDate.class, new LocalDateSerializer());
  }
}
