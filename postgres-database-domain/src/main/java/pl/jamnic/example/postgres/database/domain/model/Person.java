package pl.jamnic.example.postgres.database.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.jamnic.example.postgres.database.api.request.PersonCreateRequest;
import pl.jamnic.example.postgres.database.api.request.PersonUpdateRequest;
import pl.jamnic.example.postgres.database.api.response.PersonResponse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "PERSON", schema = "public")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    /* ========== CONSTRUCTORS ========== */
    public Person(PersonCreateRequest request) {
        name = request.getName();
        surname = request.getSurname();
    }

    /* ========== SERVICES ========== */
    public void update(PersonUpdateRequest request) {
        changeName(request.getName());
        changeSurname(request.getSurname());
    }

    /* ========== ASSEMBLY ========== */
    public PersonResponse toDto() {
        return PersonResponse.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .build();
    }

    /* ========== PRIVATE ========== */
    private void changeName(String newName) {
        if (newName != null)
            name = newName;
    }

    private void changeSurname(String newSurname) {
        if (newSurname != null)
            surname = newSurname;
    }

}
