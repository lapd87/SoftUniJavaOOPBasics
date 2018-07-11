package exam.characters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 09:18 ч.
 */
public abstract class ComicCharacterImpl implements ComicCharacter {

    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> superPowers;

    protected ComicCharacterImpl(String name, int energy,
                              double health, double intelligence) {
        setName(name);
        setEnergy(energy);
        setHealth(health);
        setIntelligence(intelligence);
        this.superPowers = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.matches("[a-zA-Z_]{2,12}")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Comic Character name is not in the correct format!");
        }
    }

    private void setEnergy(int energy) {
        if (energy >= 0 && energy <= 300) {
            this.energy = energy;
        } else {
            throw new IllegalArgumentException("Energy is not in the correct range!");
        }
    }

    private void setHealth(double health) {
        if (health > 0) {
            this.health = health;
        } else {
            throw new IllegalArgumentException("Health should be a possitive number!");
        }
    }

    private void setIntelligence(double intelligence) {
        if (intelligence > 0 && intelligence <= 200) {
            this.intelligence = intelligence;
        } else {
            throw new IllegalArgumentException("Intelligence is not in the correct range!");
        }
    }

    @Override
    public List<SuperPower> getSuperPowers() {
        return Collections.unmodifiableList(superPowers);
    }

    @Override
    public void takeDamage(double damage) {
        this.health = getHealth() - damage;
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        setEnergy(energy);
        setHealth(health);
        setIntelligence(intelligence);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public double getIntelligence() {
        return intelligence;
    }

    @Override
    public String useSuperPowers() {
        if (getSuperPowers().size() == 0) {
            return String.format("%s has no super powers!", getName());
        }

        for (SuperPower superPower : superPowers) {
            this.energy += superPower.getPowerPoints();
            this.health += superPower.getPowerPoints() * 2;
        }

        return String.format("%s used his super powers!",
                getName());
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        this.superPowers.add(superPower);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("#Name: %s",
                getName()))
                .append(System.lineSeparator())
                .append(String.format("##Health: %.2f// Energy: %d// Intelligence: %.2f",
                        getHealth(), getEnergy(), getIntelligence()));

        return stringBuilder.toString();
    }
}