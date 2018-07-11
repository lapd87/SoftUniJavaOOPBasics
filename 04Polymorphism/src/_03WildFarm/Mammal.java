package _03WildFarm;

import java.text.DecimalFormat;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.6.2018 г.
 * Time: 10:20 ч.
 */
public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal() {
        super();
    }

    public Mammal(String animalName, String animalType,
                  Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        setLivingRegion(livingRegion);
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                new DecimalFormat("#.##")
                        .format(getAnimalWeight()),
                this.getLivingRegion(),
                super.getFoodEaten());
    }
}