package xyz.rpolnx.java_layers.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import xyz.rpolnx.java_layers.model.entity.Person;
import xyz.rpolnx.java_layers.repository.PersonRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class SeedDatabase {
    @Value("${seed.database.times:50}")
    private int times;

    private final PersonRepository repository;

    @PostConstruct
    public void seed() {
        for (int i = 0; i < times; i++) {
            String name = UUID.randomUUID().toString();
            String cpf = name.replace("-", "").substring(0, 11);
            Person person = new Person(name, cpf, LocalDate.now().minusYears(25));
            repository.create(person);
        }
    }
}
