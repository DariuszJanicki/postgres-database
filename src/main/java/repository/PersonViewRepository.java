package repository;

import model.view.ViewPerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonViewRepository extends CrudRepository<ViewPerson, Long> {
}
