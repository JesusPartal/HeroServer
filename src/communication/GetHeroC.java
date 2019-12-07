package communication;

import model.HeroFactory;
import model.HeroType;
import model.SuperHero;
import model.SuperVillain;
import java.rmi.server.UnicastRemoteObject;

public class GetHeroC extends UnicastRemoteObject implements GetHeroI {
    public GetHeroC() throws Exception {
        super();
    }

    @Override
    public SuperHero getHero(SuperVillain superVillain) throws Exception {

        SuperHero superHero = (superVillain instanceof model.BadFlyPerson)
                ? HeroFactory.buildHero(HeroType.GOODFLYPERSON,
                superVillain.getHealthPoints(),
                superVillain.getBadnessPower())
                : HeroFactory.buildHero(HeroType.GOODSTRONGMAN,
                superVillain.getHealthPoints(),
                superVillain.getBadnessPower());

        return superHero;
    }
}
