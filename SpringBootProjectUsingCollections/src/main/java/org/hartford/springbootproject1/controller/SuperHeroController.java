package org.hartford.springbootproject1.controller;

import org.hartford.springbootproject1.model.SuperHero;
import org.hartford.springbootproject1.service.SuperHeroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/superheroes")
public class SuperHeroController {
    private final SuperHeroService service;

    public SuperHeroController(SuperHeroService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public SuperHero addSuperHero(@RequestBody SuperHero superHero) {
        return service.save(superHero);
    }

    @DeleteMapping("/delete/{id}")
    public boolean removeSuperHero(@PathVariable int id) {
        return service.deleteById(id);
    }

    @GetMapping
    public List<SuperHero> findAllSuperHeroes() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SuperHero findSuperHeroById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping("/search/{superPower}")
    public List<SuperHero> findBySuperPower(@PathVariable String superPower) {
        return service.findBySuperPower(superPower);
    }

    @GetMapping("/sort/powerlevel")
    public List<SuperHero> sortByPowerLevel() {
        return service.sortByPowerLevel();
    }

    @PutMapping("/{id}")
    public SuperHero updateSuperHeroById(@PathVariable int id, @RequestBody SuperHero superHero) {
        return service.update(id, superHero);
    }
}

