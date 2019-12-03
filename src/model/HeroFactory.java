package model;

public class HeroFactory {
    public static SuperHero buildHero(HeroType type, int minimumPower, int healthpoints) {

        SuperHero superHero = null;

        switch(type) {
            case GOODSTRONGMAN:
                superHero = new GoodStrongMan(minimumPower, healthpoints);
                break;
            case GOODFLYPERSON:
                superHero = new GoodFlyPerson(minimumPower, healthpoints);
                break;
            default:
                break;
        }

        return superHero;
    }
}
