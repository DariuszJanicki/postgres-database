package pl.jamnic.example.postgres.database.api.service;

import pl.jamnic.example.postgres.database.api.request.PersonCreateRequest;
import pl.jamnic.example.postgres.database.api.request.PersonUpdateRequest;

public interface PersonService {

    void create(PersonCreateRequest request);

    void update(PersonUpdateRequest request);
}
