package com.insightfindr.service;

import com.insightfindr.model.Person;
import com.insightfindr.model.Stock;

import java.util.List;

public interface PersonService {
    //Add all the required functions here.
    public Person getPersonById(String id) throws Exception; //Once the person has been retrieved you can get the list of stocks.
    public Person postPerson(Person person);
    public Person putPerson(Person person, String id); //This can be used to add the stocks to the Person.
    public Person deletePerson(String id);
}
