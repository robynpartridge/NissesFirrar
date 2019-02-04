package com.example.NissesFirrar.controllers;

import com.example.NissesFirrar.exceptions.ResourceNotFoundException;
import com.example.NissesFirrar.models.Person;
import com.example.NissesFirrar.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController (PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path="/person")
    public List<Person> get(@RequestParam(value="name", required = false)String name) {
        return name == null ? personService.all(): personService.getByName(name);
    }
    @GetMapping(path = "/person/{id}")
    public Person getById(@PathVariable(name = "id") Long id) {
        return personService.getById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
    @PostMapping(path = "/person")
    public ResponseEntity<Person> create(@RequestBody @Valid Person person) {
        Person createdPerson = personService.create(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @PutMapping(path = "/person/{id}")
    public ResponseEntity<Person> update(@PathVariable(name = "id") Long id,
                                           @RequestBody @Valid Person person) {
        Person updatedPerson = personService.update(person, id);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @DeleteMapping(path = "/person/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") Long id) { personService.delete(id); }

}
