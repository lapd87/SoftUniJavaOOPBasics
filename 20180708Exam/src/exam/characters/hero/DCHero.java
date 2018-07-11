package exam.characters.hero;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 09:34 ч.
 */
public class DCHero extends Hero {

    public DCHero(String name, int energy, double health,
                  double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return getEnergy() / 1.5 + getSpecial() + getIntelligence();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("####DC Attack Power: %.2f",
                        attack()));

        return stringBuilder.toString();
    }
}