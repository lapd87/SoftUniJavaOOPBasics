package exam.characters.antihero;

import exam.characters.ComicCharacterImpl;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 09:35 ч.
 */
public abstract class AntiHero extends ComicCharacterImpl {

    private double evilness;

    protected AntiHero(String name, int energy, double health,
                    double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        setEvilness(evilness);
    }

    private void setEvilness(double evilness) {
        if (evilness >= 0) {
            this.evilness = evilness;
        } else {
            throw new IllegalArgumentException("Evilness should be a possitive number!");
        }
    }

    private double getEvilness() {
        return evilness;
    }

    @Override
    public double getSpecial() {
        return getEvilness();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("###Evilness: %.2f",
                        getSpecial()));

        return stringBuilder.toString();
    }
}