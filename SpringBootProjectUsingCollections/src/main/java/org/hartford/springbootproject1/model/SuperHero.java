package org.hartford.springbootproject1.model;

public class SuperHero {
    private int id;
    private String name;
    private String superPower;
    private String weakness;
    private int powerLevel;


    public SuperHero() {
    }

    public SuperHero(int id, String name, String superPower, String weakness, int powerLevel) {
        this.id = id;
        this.name = name;
        this.superPower = superPower;
        this.weakness = weakness;
        this.powerLevel = powerLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
