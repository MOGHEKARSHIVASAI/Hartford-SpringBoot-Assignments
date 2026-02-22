package org.hartford.springbootproject1.controller;

import org.hartford.springbootproject1.model.Business;
import org.hartford.springbootproject1.service.BusinessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/businesses")
public class BusinessController {
    private final BusinessService service;

    public BusinessController(BusinessService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Business addBusiness(@RequestBody Business business) {
        return service.save(business);
    }

    @DeleteMapping("/delete/{id}")
    public boolean removeBusiness(@PathVariable int id) {
        return service.deleteById(id);
    }

    @GetMapping
    public List<Business> findAllBusinesses() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Business findBusinessById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping("/industry/{industry}")
    public List<Business> findByIndustry(@PathVariable String industry) {
        return service.findByIndustry(industry);
    }

    @GetMapping("/location/{location}")
    public List<Business> findByLocation(@PathVariable String location) {
        return service.findByLocation(location);
    }

    @GetMapping("/sort/revenue")
    public List<Business> sortByRevenue() {
        return service.sortByRevenue();
    }

    @PutMapping("/{id}")
    public Business updateBusinessById(@PathVariable int id, @RequestBody Business business) {
        return service.update(id, business);
    }
}

