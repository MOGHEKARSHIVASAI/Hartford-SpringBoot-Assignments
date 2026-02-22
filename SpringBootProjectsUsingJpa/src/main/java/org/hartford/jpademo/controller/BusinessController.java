package org.hartford.jpademo.controller;

import org.hartford.jpademo.entity.Business;
import org.hartford.jpademo.service.BusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/businesses")
public class BusinessController {
    private final BusinessService service;

    public BusinessController(BusinessService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Business> addBusiness(@RequestBody Business business) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addBusiness(business));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Business> getBusinessById(@PathVariable Long id) {
        Business business = service.findById(id);
        if (business != null) {
            return ResponseEntity.ok(business);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Business> getAllBusinesses() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBusinessById(@PathVariable Long id) {
        if (service.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Business> updateBusiness(@PathVariable Long id, @RequestBody Business business) {
        Business updated = service.update(id, business);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search/industry/{industry}")
    public List<Business> findByIndustry(@PathVariable String industry) {
        return service.findByIndustry(industry);
    }

    @GetMapping("/search/location/{location}")
    public List<Business> findByLocation(@PathVariable String location) {
        return service.findByLocation(location);
    }

    @GetMapping("/sort/revenue")
    public List<Business> sortByRevenue() {
        return service.sortByRevenue();
    }

    @GetMapping("/search/revenue/{revenue}")
    public List<Business> findByRevenueGreaterThan(@PathVariable double revenue) {
        return service.findByRevenueGreaterThan(revenue);
    }

    @GetMapping("/search/industry/{industry}/location/{location}")
    public List<Business> findByIndustryAndLocation(@PathVariable String industry, @PathVariable String location) {
        return service.findByIndustryAndLocation(industry, location);
    }
}

