package one.digitalinnovation.personapi.config.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new InfoImpl()
                        .title("Person - API")
                        .description("Api created for the Bootcamp Code Anywhere ")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Alexandre Luiz Tavares")
                                .email("altavares03@outlook.com"))
                );
    }
}
