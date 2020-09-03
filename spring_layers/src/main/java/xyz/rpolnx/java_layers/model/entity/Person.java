package xyz.rpolnx.java_layers.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class Person {
    private static final long MAX_ID = 1000000L;

    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthday;

    public Person(String name, String cpf, LocalDate birthday) {
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
    }

    public Person withNewId() {
        this.id = (long) (Math.random() * MAX_ID);
        return this;
    }
}
