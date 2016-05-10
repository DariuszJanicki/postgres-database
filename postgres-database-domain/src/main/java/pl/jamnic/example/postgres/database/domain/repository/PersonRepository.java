package pl.jamnic.example.postgres.database.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jamnic.example.postgres.database.domain.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
