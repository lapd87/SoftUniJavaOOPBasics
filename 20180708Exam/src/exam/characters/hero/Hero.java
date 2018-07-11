package exam.characters.hero;

import exam.characters.ComicCharacterImpl;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 09:29 ч.
 */
public abstract class Hero extends ComicCharacterImpl {

    private double heroism;

    protected Hero(String name, int energy, double health,
                double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        setHeroism(heroism);
    }

    private void setHeroism(double heroism) {
        if (heroism >= 0) {
            this.heroism = heroism;
        } else {
            throw new IllegalArgumentException("Heroism should be a possitive number!");
        }
    }

    private double getHeroism() {
        return heroism;
    }

    @Override
    public double getSpecial() {
        return getHeroism();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("###Heroism: %.2f",
                        getSpecial()));

        return stringBuilder.toString();
    }
}