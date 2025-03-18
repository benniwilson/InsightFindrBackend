package com.insightfindr.service;

import com.insightfindr.exception.PersonNotFoundException;
import com.insightfindr.model.Person;
import com.insightfindr.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository repository;

    @Override
    public Person getPersonById(String id) throws Exception {
        Optional<Person> person = repository.findById(id);
        if (person.isPresent()){
            return person.get();
        }else {
            throw new PersonNotFoundException(String.format("No user with id: %s, was found in the system", id));
        }
    }

    @Override
    public Person postPerson(Person person) {
        return repository.save(person);
    }

    @Override
    public Person putPerson(Person person, String id) {
        Optional<Person> optionalPerson = repository.findById(id);
        if (optionalPerson.isPresent()){
            person.setUser_id(id);
            return repository.save(person);
        }else{
            throw new PersonNotFoundException(String.format("No user with id: %s, was found in the system", id));
        }
    }

    @Override
    public Person deletePerson(String id) {
        Optional<Person> person = repository.findById(id);
        if (person.isPresent()){
            Person deletedPerson = person.get();
            repository.deleteById(id);
            return deletedPerson;
        }else {
            throw new PersonNotFoundException(String.format("No user with id: %s, was found in the system", id));
        }
    }
}
