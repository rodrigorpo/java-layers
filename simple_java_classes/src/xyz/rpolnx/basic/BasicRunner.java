package xyz.rpolnx.basic;

import xyz.rpolnx.common.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BasicRunner {
    private static final List<Person> DATABASE = new ArrayList<>();
    private static final int MINIMUM_AGE = 14;

    public static void main(String[] args) throws Exception {
        try {
            Person person = new Person("Person 1", "01234567891", LocalDate.of(1990, 10, 1));
            Person person2 = new Person("Person 2", "01234567892", LocalDate.of(1991, 11, 2));
            Person person3 = new Person("Person 3", "01234567893", LocalDate.of(1992, 12, 3));

            Long personOneId = handleRequest(person);
            Long personTwoId = handleRequest(person2);
            Long personThreeId = handleRequest(person3);

            System.out.println("Created person one with id: " + personOneId);
            System.out.println("Created person one with id: " + personTwoId);
            System.out.println("Created person one with id: " + personThreeId);

            System.out.println("Current database is: " + DATABASE);

            Person personWithWrongAge = new Person("Person 3", "01234567893", LocalDate.of(2010, 12, 3));

            handleRequest(personWithWrongAge);

        } catch (Exception e) {
            System.out.println("User creation failed with error: " + e.getMessage());
        }

    }

    //handle basic input logic
    private static Long handleRequest(Person person) throws Exception {

        if (person == null) {
            throw new Exception("Person object cannot be null");
        }

        if (person.getCpf() == null || person.getCpf().isEmpty()) {
            throw new Exception("Cpf cannot be null or empty");
        }

        if (person.getBirthday() == null) {
            throw new Exception("Birthday cannot be null or empty");
        }

        return handleCreation(person);
    }

    //handle some business logic
    private static Long handleCreation(Person person) throws Exception {

        // verify person lowest age
        if (person.getBirthday().isAfter(LocalDate.now().minusYears(MINIMUM_AGE))) {
            throw new Exception("Person must be majority to create account");
        }

        Person created = createPerson(person);

        return created.getId();
    }

    //handle data communication
    private static Person createPerson(Person person) {
        long id = (long) (Math.random() * 10000);

        person.setId(id);

        DATABASE.add(person);

        return person;
    }
}
