package pl.jamnic.example.postgres.database.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.jamnic.example.postgres.database.domain.config.DomainConfiguration;
import pl.jamnic.example.postgres.database.web.config.WebConfiguration;

@SpringBootApplication
@Import(value = {DomainConfiguration.class, WebConfiguration.class})
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
