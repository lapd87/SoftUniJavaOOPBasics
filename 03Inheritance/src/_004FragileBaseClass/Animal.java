package _004FragileBaseClass;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 11:22 ч.
 */
public class Animal {

    protected ArrayList<Food> foodEaten;

    public final void eat(Food food) {
        foodEaten.add(food);
    }

    public void eatAll(Food[] foods) {
        Collections.addAll(foodEaten, foods);
    }
}