package model;

import java.io.Serializable;

public class GoodStrongMan extends SuperHero implements StrengthInterface, Serializable {

    private static final long serialVersionUID = 1L;

    public GoodStrongMan(int goodness, int healthpoints) {
        super(goodness, healthpoints);
    }
    public void strength() {
        System.out.println("model.GoodStrongMan is using his strength power");
    }


    @Override
    public String getStats() {
        return "GOODSTRONGMAN -> HP: " + this.getHealthPoints() +
                " - GP: " + this.getGoodnessPower();
    }
}