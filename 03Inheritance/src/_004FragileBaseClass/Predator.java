package _004FragileBaseClass;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 11:25 ч.
 */
public class Predator extends Animal {

    private int health;

    public void feed(Food food) {
        super.eat(food);
        health++;
    }
}