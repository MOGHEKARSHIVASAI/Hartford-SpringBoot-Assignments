package org.hartford.jpademo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "super_hero")
public class SuperHero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String superPower;

    @Column(nullable = false)
    private String weakness;

    @Column(nullable = false)
    private int powerLevel;

    public SuperHero() {
    }

    public SuperHero(Long id, String name, String superPower, String weakness, int powerLevel) {
        this.id = id;
        this.name = name;
        this.superPower = superPower;
        this.weakness = weakness;
        this.powerLevel = powerLevel;
    }

    public SuperHero(String name, String superPower, String weakness, int powerLevel) {
        this.name = name;
        this.superPower = superPower;
        this.weakness = weakness;
        this.powerLevel = powerLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", superPower='" + superPower + '\'' +
                ", weakness='" + weakness + '\'' +
                ", powerLevel=" + powerLevel +
                '}';
    }
}

