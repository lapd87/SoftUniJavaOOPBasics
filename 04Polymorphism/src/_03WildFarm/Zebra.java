package _03WildFarm;

import static _03WildFarm.Constants.ZEBRA_SOUND;
import static _03WildFarm.Constants.ZEBRA_UNCOMPATABLE_FOOD_TYPE_MESSAGE;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.6.2018 г.
 * Time: 10:22 ч.
 */
public class Zebra extends Mammal {

    public Zebra() {
    super();
    }

    public Zebra(String animalName, String animalType,
                 Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println(ZEBRA_SOUND);
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException(ZEBRA_UNCOMPATABLE_FOOD_TYPE_MESSAGE);
        }

        setFoodEaten(getFoodEaten() + food.getQuantity());
    }
}