package org.hartford.springbootproject1.service;

import org.hartford.springbootproject1.model.SuperHero;

import java.util.List;

public interface SuperHeroService {
    SuperHero save(SuperHero superHero);
    boolean deleteById(int id);
    List<SuperHero> findAll();
    SuperHero findById(int id);
    SuperHero update(int id, SuperHero superHero);
    List<SuperHero> findBySuperPower(String superPower);
    List<SuperHero> sortByPowerLevel();
}

