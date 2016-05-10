package pl.jamnic.example.postgres.database.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jamnic.example.postgres.database.api.request.PersonCreateRequest;
import pl.jamnic.example.postgres.database.api.request.PersonUpdateRequest;
import pl.jamnic.example.postgres.database.api.response.PersonResponse;
import pl.jamnic.example.postgres.database.api.service.PersonFinder;
import pl.jamnic.example.postgres.database.api.service.PersonService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @Autowired
    private PersonFinder finder;

    @RequestMapping(value = "/{id}", method = GET)
    public PersonResponse getPerson(@PathVariable Long id) {
        log.info("Received getPerson request with id = '{}'.", id);
        return finder.getPerson(id);
    }

    @RequestMapping(method = GET)
    public List<PersonResponse> getPersons() {
        log.info("Received getPersons request.");
        return finder.getPersons();
    }

    @RequestMapping(value = "/create", method = POST)
    public void postCreate(@RequestBody PersonCreateRequest request) {
        log.info("Received postCreate request with request = '{}'.", request);
        service.create(request);
    }

    @RequestMapping(value = "/update", method = POST)
    public void postUpdate(@RequestBody PersonUpdateRequest request) {
        log.info("Received postUpdate request with request = '{}'.", request);
        service.update(request);
    }

}
