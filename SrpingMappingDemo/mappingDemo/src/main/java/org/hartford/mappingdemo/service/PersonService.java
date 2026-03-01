package org.hartford.mappingdemo.service;

import org.hartford.mappingdemo.entity.Passport;
import org.hartford.mappingdemo.entity.Person;
import org.hartford.mappingdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repo;

    public List<Person> findAll() {
        return repo.findAll();
    }
    public Person findById(Long id) {
        return repo.findById(id).orElseThrow(()->new RuntimeException("Invalid id"));
    }

    public Person addPerson(Person person) {
        return repo.save(person);
    }
    public Passport getPassportByPersonId(Long id){
        Person p=repo.findById(id).orElseThrow(()->new RuntimeException("invalid person id"));
        return p.getPassport();

    }



}
