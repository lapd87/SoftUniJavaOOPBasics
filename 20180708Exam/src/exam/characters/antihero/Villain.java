package exam.characters.antihero;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 09:37 ч.
 */
public class Villain extends AntiHero {

    public Villain(String name, int energy, double health,
                   double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (getIntelligence() * getSpecial()) / getEnergy();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("####Villain Attack Power: %.2f",
                        attack()));

        return stringBuilder.toString();
    }
}