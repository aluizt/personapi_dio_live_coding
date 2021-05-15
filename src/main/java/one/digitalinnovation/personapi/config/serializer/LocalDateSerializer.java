package one.digitalinnovation.personapi.config.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSerializer extends StdSerializer<LocalDate> {
  private static final long serialVersionUID = 7472972160234117733L;
  public LocalDateSerializer() {
    this(null);
  }
  public LocalDateSerializer(Class<LocalDate> t) {
    super(t);
  }
  @Override
  public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    gen.writeString(value.format(DateTimeFormatter.ISO_DATE));
  }
}
