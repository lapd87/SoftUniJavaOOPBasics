package _03WildFarm;

import java.text.DecimalFormat;

import static _03WildFarm.Constants.CAT_SOUND;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.6.2018 г.
 * Time: 10:21 ч.
 */
public class Cat extends Feline {

    private String breed;

    public Cat() {
        super();
    }

    public Cat(String animalName, String animalType,
               Double animalWeight, String livingRegion,
               String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        setBreed(breed);
    }

    private String getBreed() {
        return breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(CAT_SOUND);
    }

    @Override
    public void eat(Food food) {
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                this.getBreed(),
                new DecimalFormat("#.##")
                        .format(getAnimalWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}