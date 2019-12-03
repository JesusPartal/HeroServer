package model;

import java.io.Serializable;

public class SuperHero extends SuperThing implements Serializable {

    private static final long serialVersionUID = 1L;
    private int goodnessPower;

    public SuperHero(int minimumPower, int healthpoints) {
        super(healthpoints + 1);
        this.goodnessPower = minimumPower + 1;
    }

    public int getGoodnessPower() {
        return goodnessPower;
    }
}