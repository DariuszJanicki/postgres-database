package model.db;

import dto.PersonCreateRequest;
import lombok.NoArgsConstructor;
import model.Person;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON", schema = "public")
@NoArgsConstructor
public class DbPerson extends Person {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    @Column(name = "NAME")
    private String name;

    @NotEmpty
    @Column(name = "SURNAME")
    private String surname;

    /* ========== CONSTRUCTORS ========== */
    public DbPerson(PersonCreateRequest request) {
        name = request.getName();
        surname = request.getSurname();
    }

    /* ========== SERVICES ========== */
    @Override
    public String getFullName() {
        return new StringBuilder().append(name).append(" ").append(surname).toString();
    }

    @Override
    public void changeName(String newName) {
        if (newName != null)
            name = newName;
    }

    @Override
    public void changeSurname(String newSurname) {
        if (newSurname != null)
            surname = newSurname;
    }
}
