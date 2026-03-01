package org.hartford.mappingdemo.service;

import org.hartford.mappingdemo.entity.Passport;
import org.hartford.mappingdemo.entity.Person;
import org.hartford.mappingdemo.repository.PassportRepository;
import org.hartford.mappingdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportService {
    @Autowired
    private PassportRepository repo;

    @Autowired
    private PersonRepository personRepo;

    public List<Passport> findAll() {
        return repo.findAll();
    }

    public Passport findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));


    }

    public Passport addPassport(Passport passport) {
        return repo.save(passport);
    }

    public Person getPersonById(Long id) {
           Passport p=repo.findById(id).orElseThrow(()->new RuntimeException("invalid passport id"));
           return p.getPerson();
    }

    public Passport bindPersonToPassport(Long passportId,Long personId){
        Passport p=repo.findById(passportId).orElseThrow(()->new RuntimeException("invalid passport id"));
        Person per=personRepo.findById(personId).orElseThrow(()->new RuntimeException("invalid person id"));
        p.setPerson(per);
        return repo.save(p);

    }


}





