package pl.jamnic.example.postgres.database.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jamnic.example.postgres.database.api.request.PersonCreateRequest;
import pl.jamnic.example.postgres.database.api.request.PersonUpdateRequest;
import pl.jamnic.example.postgres.database.api.service.PersonService;
import pl.jamnic.example.postgres.database.domain.model.Person;
import pl.jamnic.example.postgres.database.domain.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public void create(PersonCreateRequest request) {
        Person person = new Person(request);
        repository.save(person);
    }

    @Override
    public void update(PersonUpdateRequest request) {
        Person person = repository.findOne(request.getId());
        person.update(request);
        repository.save(person);
    }

}
