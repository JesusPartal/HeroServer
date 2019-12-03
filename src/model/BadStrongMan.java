package model;

import java.io.Serializable;

public class BadStrongMan extends SuperVillain implements StrengthInterface, Serializable {
    private static final long serialVersionUID = 1L;

    public BadStrongMan() {
        super();
    }

    public void strength() {
        System.out.println("model.BadStrongMan is using this super strength...");
    }

    @Override
    public String getStats() {
        return "model.BadStrongMan -> HP: " + this.getHealthPoints() +
                " - BP: " + this.getBadnessPower();
    }
}