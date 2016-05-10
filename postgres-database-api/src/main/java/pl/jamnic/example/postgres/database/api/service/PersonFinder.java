package pl.jamnic.example.postgres.database.api.service;

import pl.jamnic.example.postgres.database.api.response.PersonResponse;

import java.util.List;

public interface PersonFinder {

    List<PersonResponse> getPersons();

    PersonResponse getPerson(Long id);

}
