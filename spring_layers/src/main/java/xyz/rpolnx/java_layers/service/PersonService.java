package xyz.rpolnx.java_layers.service;

import xyz.rpolnx.java_layers.model.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO create(PersonDTO person);

    List<PersonDTO> getAll();

    PersonDTO get(Long id);
}
