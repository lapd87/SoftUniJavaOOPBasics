package _03WildFarm;

import static _03WildFarm.Constants.MOUSE_SOUND;
import static _03WildFarm.Constants.MOUSE_UNCOMPATABLE_FOOD_TYPE_MESSAGE;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.6.2018 г.
 * Time: 10:21 ч.
 */
public class Mouse extends Mammal {

    public Mouse() {
        super();
    }

    public Mouse(String animalName, String animalType,
                 Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println(MOUSE_SOUND);
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException(MOUSE_UNCOMPATABLE_FOOD_TYPE_MESSAGE);
        }

        setFoodEaten(getFoodEaten() + food.getQuantity());
    }
}