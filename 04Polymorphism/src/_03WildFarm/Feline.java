package _03WildFarm;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.6.2018 г.
 * Time: 10:21 ч.
 */
public abstract class Feline extends Mammal {

    public Feline() {
        super();
    }

    public Feline(String animalName, String animalType,
                  Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }
}