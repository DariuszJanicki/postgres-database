package pl.jamnic.example.postgres.database.domain.config;


import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "pl.jamnic.example.postgres.database.domain.model")
@ComponentScan(basePackages = "pl.jamnic.example.postgres.database.domain.service")
@EnableJpaRepositories(basePackages = "pl.jamnic.example.postgres.database.domain.repository")
public class DomainConfiguration {
}
