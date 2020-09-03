package xyz.rpolnx.java_layers.repository.impl;

import org.springframework.stereotype.Component;
import xyz.rpolnx.java_layers.model.entity.Person;
import xyz.rpolnx.java_layers.repository.PersonRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

@Component
public class InMemoryDatabase implements PersonRepository {
    private Map<Long, Person> people = new HashMap<>();

    @Override
    public Long create(Person person) {
        Person created = person.withNewId();

        if (randomIdExists(created)) {
            return create(person);
        }

        people.put(created.getId(), created);

        return created.getId();
    }

    private boolean randomIdExists(Person created) {
        return nonNull(people.get(created.getId()));
    }

    @Override
    public List<Person> getAll() {
        return new ArrayList<>(people.values());
    }

    @Override
    public Person get(Long id) {
        return people.get(id);
    }
}
