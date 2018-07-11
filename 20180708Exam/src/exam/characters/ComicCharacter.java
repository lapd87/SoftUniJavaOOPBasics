package exam.characters;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 09:26 ч.
 */
public interface ComicCharacter {

    List<SuperPower> getSuperPowers();

    void takeDamage(double damage);

    void boostCharacter(int energy, double health, double intelligence);

    String getName();

    int getEnergy();

    double getHealth();

    double getIntelligence();

    String useSuperPowers();

    void addSuperPower(SuperPower superPower);

    double getSpecial();

    double attack();

}
