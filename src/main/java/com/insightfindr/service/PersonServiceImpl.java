package com.insightfindr.service;

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
            throw new Exception(String.format("No Album with id: %s, was found in the system", id));
        }
    }

    @Override
    public Person postPerson(Person person) {
        return null;
    }

    @Override
    public Person putPerson(Person person, String id) {
        return null;
    }

    @Override
    public Person deletePerson(String id) {
        return null;
    }
}
