package org.hartford.jpademo.service;

import org.hartford.jpademo.entity.SuperHero;
import org.hartford.jpademo.repository.SuperHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroService {
    @Autowired
    private SuperHeroRepository repo;

    public SuperHero addSuperHero(SuperHero superHero) {
        return repo.save(superHero);
    }

    public boolean deleteById(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<SuperHero> findAll() {
        return repo.findAll();
    }

    public SuperHero findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public SuperHero update(Long id, SuperHero sh) {
        SuperHero superHero = findById(id);
        if (superHero != null) {
            superHero.setName(sh.getName());
            superHero.setSuperPower(sh.getSuperPower());
            superHero.setWeakness(sh.getWeakness());
            superHero.setPowerLevel(sh.getPowerLevel());
            repo.save(superHero);
            return superHero;
        }
        return null;
    }

    public List<SuperHero> findBySuperPower(String superPower) {
        return repo.findBySuperPower(superPower);
    }

    public List<SuperHero> findByNameContaining(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    public List<SuperHero> sortByPowerLevel() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "powerLevel"));
    }

    public List<SuperHero> findByPowerLevelGreaterThan(int powerLevel) {
        return repo.findByPowerLevelGreaterThan(powerLevel);
    }
}

