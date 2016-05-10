package controller;

import com.google.common.collect.Lists;
import dto.PersonCreateRequest;
import dto.PersonUpdateRequest;
import lombok.extern.slf4j.Slf4j;
import model.Person;
import model.db.DbPerson;
import model.view.ViewPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.PersonRepository;
import repository.PersonViewRepository;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@CrossOrigin
@RequestMapping("/person")
@RestController
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonViewRepository viewRepository;

    @RequestMapping(value = "/{id}", method = GET)
    public ViewPerson getPerson(@PathVariable Long id) {
        log.info("Received getPerson request with id = '{}'.", id);
        ViewPerson person = viewRepository.findOne(id);
        return person;
    }

    @RequestMapping(method = GET)
    public List<ViewPerson> getPersons() {
        log.info("Received getPersons request.");
        List<ViewPerson> persons = Lists.newArrayList(viewRepository.findAll());
        return persons;
    }

    @RequestMapping(value = "/create", method = POST)
    public void postCreate(@RequestBody PersonCreateRequest request) {
        log.info("Received postCreate request with request = '{}'.", request);
        DbPerson person = new DbPerson(request);
        repository.save(person);
    }

    @RequestMapping(value = "/update", method = POST)
    public void postUpdate(@RequestBody PersonUpdateRequest request) {
        log.info("Received postUpdate request with request = '{}'.", request);
        Person one = repository.findOne(request.getId());
        request.getNewName().ifPresent(one::changeName);
        request.getNewSurname().ifPresent(one::changeSurname);
    }

}
