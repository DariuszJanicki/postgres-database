package pl.jamnic.example.postgres.database.domain.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.jamnic.example.postgres.database.api.response.PersonResponse;
import pl.jamnic.example.postgres.database.api.service.PersonFinder;
import pl.jamnic.example.postgres.database.domain.model.Person;
import pl.jamnic.example.postgres.database.domain.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonFinderImpl implements PersonFinder {

    @Autowired
    private PersonRepository repository;

    @Override
    public List<PersonResponse> getPersons() {
        return Lists.newArrayList(repository.findAll()).stream()
                .map(Person::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonResponse getPerson(Long id) {
        return repository.findOne(id).toDto();
    }

}
