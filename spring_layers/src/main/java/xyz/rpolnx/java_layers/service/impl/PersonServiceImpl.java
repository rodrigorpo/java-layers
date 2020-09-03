package xyz.rpolnx.java_layers.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.rpolnx.java_layers.model.dto.PersonDTO;
import xyz.rpolnx.java_layers.model.entity.Person;
import xyz.rpolnx.java_layers.repository.PersonRepository;
import xyz.rpolnx.java_layers.service.PersonService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;

    @Override
    public PersonDTO create(PersonDTO dto) {
        Person person = new Person(dto.getName(), dto.getCpf(), dto.getBirthday());

        Long id = repository.create(person);

        return new PersonDTO().withId(id);
    }

    @Override
    public List<PersonDTO> getAll() {
        return repository.getAll().stream()
                .map(PersonDTO::fromEntity)
                .collect(toList());
    }

    @Override
    public PersonDTO get(Long id) {
        Person person = repository.get(id);

        return PersonDTO.fromEntity(person);
    }
}
