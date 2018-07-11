package _03WildFarm;

import static _03WildFarm.Constants.TIGER_SOUND;
import static _03WildFarm.Constants.TIGER_UNCOMPATABLE_FOOD_TYPE_MESSAGE;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.6.2018 г.
 * Time: 10:22 ч.
 */
public class Tiger extends Feline {

    public Tiger() {
        super();
    }

    public Tiger(String animalName, String animalType,
                 Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println(TIGER_SOUND);
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException(TIGER_UNCOMPATABLE_FOOD_TYPE_MESSAGE);
        }

        setFoodEaten(getFoodEaten() + food.getQuantity());
    }
}