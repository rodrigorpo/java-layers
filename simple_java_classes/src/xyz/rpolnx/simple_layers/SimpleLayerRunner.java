package xyz.rpolnx.simple_layers;

import xyz.rpolnx.common.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//handle basic input logic
class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public Long createPerson(Person person) throws Exception {

        if (person == null) {
            throw new Exception("Person object cannot be null");
        }

        if (person.getCpf() == null || person.getCpf().isEmpty()) {
            throw new Exception("Cpf cannot be null or empty");
        }

        if (person.getBirthday() == null) {
            throw new Exception("Birthday cannot be null or empty");
        }

        return personService.handleCreation(person);
    }

    public List<Person> getPeople() {
        return personService.getPeople();
    }
}

//handle some business logic
class PersonService {
    private static final int MINIMUM_AGE = 14;

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Long handleCreation(Person person) throws Exception {

        // verify person lowest age
        if (person.getBirthday().isAfter(LocalDate.now().minusYears(MINIMUM_AGE))) {
            throw new Exception("Person must be majority to create account");
        }

        Person created = personRepository.createPerson(person);

        return created.getId();
    }

    public List<Person> getPeople() {
        return personRepository.getPeople();
    }

}

//handle data communication
class PersonRepository {
    private final List<Person> DATABASE;

    public PersonRepository() {
        this.DATABASE = new ArrayList<>();
    }

    public Person createPerson(Person person) {
        long id = (long) (Math.random() * 10000);

        person.setId(id);

        DATABASE.add(person);

        return person;
    }

    public List<Person> getPeople() {
        return DATABASE;
    }
}

public class SimpleLayerRunner {

    public static void main(String[] args) throws Exception {
        try {
            Person person = new Person("Person 1", "01234567891", LocalDate.of(1990, 10, 1));
            Person person2 = new Person("Person 2", "01234567892", LocalDate.of(1991, 11, 2));
            Person person3 = new Person("Person 3", "01234567893", LocalDate.of(1992, 12, 3));

            // Layers creation
            PersonRepository personRepository = new PersonRepository();
            PersonService personService = new PersonService(personRepository);
            PersonController personController = new PersonController(personService);


            Long personOneId = personController.createPerson(person);
            Long personTwoId = personController.createPerson(person2);
            Long personThreeId = personController.createPerson(person3);

            System.out.println("Created person one with id: " + personOneId);
            System.out.println("Created person one with id: " + personTwoId);
            System.out.println("Created person one with id: " + personThreeId);

            // Now we have to access through the controller
            List<Person> people = personController.getPeople();
            System.out.println("Current database is: " + people);


            Person personWithWrongAge = new Person("Person 3", "01234567893", LocalDate.of(2010, 12, 3));

            personController.createPerson(personWithWrongAge);

        } catch (Exception e) {
            System.out.println("User creation failed with error: " + e.getMessage());
        }
    }
}
