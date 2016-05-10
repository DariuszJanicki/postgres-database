package model.view;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_view", schema = "public")
@NoArgsConstructor
@Getter
public class ViewPerson {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

}
