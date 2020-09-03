package xyz.rpolnx.java_layers.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.rpolnx.java_layers.model.dto.PersonDTO;
import xyz.rpolnx.java_layers.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public List<PersonDTO> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public PersonDTO getSingle(@PathVariable("id") Long id) {
        return personService.get(id);
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }
}
