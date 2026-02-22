package org.hartford.springbootproject1.service;

import org.hartford.springbootproject1.dao.SuperHeroDao;
import org.hartford.springbootproject1.model.SuperHero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {
    private final SuperHeroDao dao;

    public SuperHeroServiceImpl(SuperHeroDao dao) {
        this.dao = dao;
    }

    @Override
    public SuperHero save(SuperHero superHero) {
        return dao.save(superHero);
    }

    @Override
    public boolean deleteById(int id) {
        return dao.deleteById(id);
    }

    @Override
    public List<SuperHero> findAll() {
        return dao.findAll();
    }

    @Override
    public SuperHero findById(int id) {
        return dao.findById(id);
    }

    @Override
    public SuperHero update(int id, SuperHero superHero) {
        return dao.update(id, superHero);
    }

    @Override
    public List<SuperHero> findBySuperPower(String superPower) {
        return dao.findBySuperPower(superPower);
    }

    @Override
    public List<SuperHero> sortByPowerLevel() {
        return dao.sortByPowerLevel();
    }
}

