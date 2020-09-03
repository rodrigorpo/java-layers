package xyz.rpolnx.java_layers.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import xyz.rpolnx.java_layers.model.entity.Person;

import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(NON_NULL)
public class PersonDTO {
    @With
    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthday;

    public static PersonDTO fromEntity(Person entity) {
        return new PersonDTO(entity.getId(), entity.getName(), entity.getCpf(), entity.getBirthday());
    }
}
