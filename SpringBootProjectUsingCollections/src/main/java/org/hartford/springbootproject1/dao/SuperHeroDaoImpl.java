package org.hartford.springbootproject1.dao;

import org.hartford.springbootproject1.model.SuperHero;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class SuperHeroDaoImpl implements SuperHeroDao {
    List<SuperHero> superHeroes = new ArrayList<>();

    @Override
    public SuperHero save(SuperHero superHero) {
        superHeroes.add(superHero);
        return superHero;
    }

    @Override
    public boolean deleteById(int id) {
        Iterator<SuperHero> it = superHeroes.iterator();
        while (it.hasNext()) {
            SuperHero sh = it.next();
            if (sh.getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<SuperHero> findAll() {
        return superHeroes;
    }

    @Override
    public SuperHero findById(int id) {
        for (SuperHero sh : superHeroes) {
            if (sh.getId() == id) {
                return sh;
            }
        }
        return null;
    }

    @Override
    public SuperHero update(int id, SuperHero superHero) {
        for (SuperHero sh : superHeroes) {
            if (sh.getId() == id) {
                sh.setName(superHero.getName());
                sh.setSuperPower(superHero.getSuperPower());
                sh.setWeakness(superHero.getWeakness());
                sh.setPowerLevel(superHero.getPowerLevel());
                return sh;
            }
        }
        return null;
    }

    @Override
    public List<SuperHero> findBySuperPower(String superPower) {
        List<SuperHero> res = new ArrayList<>();
        for (SuperHero sh : superHeroes) {
            if (sh.getSuperPower().equalsIgnoreCase(superPower)) {
                res.add(sh);
            }
        }
        return res;
    }

    @Override
    public List<SuperHero> sortByPowerLevel() {
        List<SuperHero> res = new ArrayList<>(superHeroes);
        res.sort((sh1, sh2) -> Integer.compare(sh2.getPowerLevel(), sh1.getPowerLevel()));
        return res;
    }
}

