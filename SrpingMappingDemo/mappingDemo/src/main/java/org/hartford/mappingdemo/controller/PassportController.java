package org.hartford.mappingdemo.controller;

import org.hartford.mappingdemo.entity.Passport;
import org.hartford.mappingdemo.entity.Person;
import org.hartford.mappingdemo.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passports")
public class PassportController {
    @Autowired
    PassportService service;

    @PostMapping
    public Passport addPassport(@RequestBody Passport p){
        return service.addPassport(p);
    }

    @GetMapping
    public List<Passport> gettAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Passport getById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/p/{id}")
    public Person getPersonByPassportId(@PathVariable Long id){
        return service.getPersonById(id);
    }

    @GetMapping("/bind/{passpoerId}/{personId}")
    public Passport bindPersonToPassport(@PathVariable Long passpoerId,@PathVariable Long personId) {
        return service.bindPersonToPassport(passpoerId, personId);
    }





}
