package org.hartford.jpademo.controller;

import org.hartford.jpademo.entity.SuperHero;
import org.hartford.jpademo.service.SuperHeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superheroes")
public class SuperHeroController {
    private final SuperHeroService service;

    public SuperHeroController(SuperHeroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SuperHero> addSuperHero(@RequestBody SuperHero superHero) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addSuperHero(superHero));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuperHero> getSuperHeroById(@PathVariable Long id) {
        SuperHero superHero = service.findById(id);
        if (superHero != null) {
            return ResponseEntity.ok(superHero);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<SuperHero> getAllSuperHeroes() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSuperHeroById(@PathVariable Long id) {
        if (service.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuperHero> updateSuperHero(@PathVariable Long id, @RequestBody SuperHero superHero) {
        SuperHero updated = service.update(id, superHero);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search/power/{superPower}")
    public List<SuperHero> findBySuperPower(@PathVariable String superPower) {
        return service.findBySuperPower(superPower);
    }

    @GetMapping("/search/name/{name}")
    public List<SuperHero> findByNameContaining(@PathVariable String name) {
        return service.findByNameContaining(name);
    }

    @GetMapping("/sort/powerlevel")
    public List<SuperHero> sortByPowerLevel() {
        return service.sortByPowerLevel();
    }

    @GetMapping("/search/powerlevel/{level}")
    public List<SuperHero> findByPowerLevelGreaterThan(@PathVariable int level) {
        return service.findByPowerLevelGreaterThan(level);
    }
}

