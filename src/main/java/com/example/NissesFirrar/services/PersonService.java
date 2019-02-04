package com.example.NissesFirrar.services;

import com.example.NissesFirrar.exceptions.ResourceNotFoundException;
import com.example.NissesFirrar.models.Person;
import com.example.NissesFirrar.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) { this.personRepository=personRepository; }
    public List<Person> all() { return personRepository.findAll(); }
    public Optional<Person> getById(Long id) { return personRepository.findById(id); }
    public List<Person> getByName(String name) { return personRepository.findByName(name); }

    public Person create(Person person) { return save(person); }
    public Person update(Person person, Long id) {
        return personRepository.findById(id)
                .map(p->){
                   p.setName()(person.getName());
                   return save(p);
        }.orElseThrow(ResourceNotFoundException::new);
    }
    public void delete(Long id) {
        personRepository.deleteById(id);
    }
    private Person save(Person personToSave) {
        return personRepository.save(personToSave);
    }
}
