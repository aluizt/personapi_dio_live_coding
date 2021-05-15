package one.digitalinnovation.personapi.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import one.digitalinnovation.personapi.config.deserializer.DeserializerModule;
import one.digitalinnovation.personapi.config.serializer.SerializerModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomObjectMapper {

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper customObjectMapper = new ObjectMapper();
    customObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    customObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    customObjectMapper.registerModules(
      new SerializerModule(),
      new DeserializerModule()
    );
    return customObjectMapper;
  }
}