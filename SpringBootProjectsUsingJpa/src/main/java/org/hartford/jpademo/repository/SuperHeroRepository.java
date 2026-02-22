package org.hartford.jpademo.repository;

import org.hartford.jpademo.entity.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {
    List<SuperHero> findBySuperPower(String superPower);
    List<SuperHero> findByNameContainingIgnoreCase(String name);
    List<SuperHero> findByPowerLevelGreaterThan(int powerLevel);
}

