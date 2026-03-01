package org.hartford.mappingdemo.controller;

import org.hartford.mappingdemo.entity.Passport;
import org.hartford.mappingdemo.entity.Person;
import org.hartford.mappingdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService service;

    @PostMapping
    public Person addPerson(@RequestBody Person person){
        return service.addPerson(person);
    }
    @GetMapping
    public List<Person> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return service.findById(id);

    }
    @GetMapping("/p/{id}")
    public Passport getPassportByPersonId(@PathVariable Long id){
        return service.getPassportByPersonId(id);
    }
}
