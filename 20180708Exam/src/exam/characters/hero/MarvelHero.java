package exam.characters.hero;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 09:34 ч.
 */
public class MarvelHero extends Hero {

    public MarvelHero(String name, int energy, double health,
                      double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return ((getEnergy() + getSpecial()) * getIntelligence()) / 2.5;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("####Marvel Attack Power: %.2f",
                        attack()));

        return stringBuilder.toString();
    }
}