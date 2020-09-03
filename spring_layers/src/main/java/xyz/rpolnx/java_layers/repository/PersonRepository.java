package xyz.rpolnx.java_layers.repository;


import xyz.rpolnx.java_layers.model.entity.Person;

import java.util.List;

public interface PersonRepository {
    Long create(Person person);

    List<Person> getAll();

    Person get(Long id);
}
