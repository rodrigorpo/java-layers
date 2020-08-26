package xyz.rpolnx.common;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthday;

    public Person() {
    }

    public Person(String name, String cpf, LocalDate birthday) {
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
    }

    public Person(Long id, String name, String cpf, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(cpf, person.cpf) &&
                Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, birthday);
    }
}
