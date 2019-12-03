package model;

import java.io.Serializable;

public class GoodFlyPerson extends SuperHero implements FlyInterface, Serializable {

    private static final long serialVersionUID = 1L;

    public GoodFlyPerson(int goodness, int healthpoints) {
        super(goodness, healthpoints);
    }

    public void fly() {
        System.out.println("model.GoodFlyPerson is using his fly power");
    }

    @Override
    public String getStats() {
        return "model.GoodFlyPerson -> HP: " + this.getHealthPoints() +
                " - GP: " + this.getGoodnessPower();
    }
}