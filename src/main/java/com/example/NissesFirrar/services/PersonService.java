package com.example.NissesFirrar.services;

import com.example.NissesFirrar.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) { this.personRepository=personRepository}
    public List<Person>
}
