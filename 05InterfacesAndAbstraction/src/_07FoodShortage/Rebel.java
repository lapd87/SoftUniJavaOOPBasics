package _07FoodShortage;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 12:58 ч.
 */
public class Rebel implements Feedable {

    private final int DEFAULT_REBEL_FOOD_INCREASE = 5;

    private String name;
    private int age;
    private String group;
    private int foodQuantity;

    public Rebel(String name, int age, String group) {
        setName(name);
        setAge(age);
        setGroup(group);
        setFoodQuantity(0);
    }

    @Override
    public int getFoodQuantity() {
        return foodQuantity;
    }

    private void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setGroup(String group) {
        this.group = group;
    }


    @Override
    public void buyFood() {
        setFoodQuantity(getFoodQuantity() + DEFAULT_REBEL_FOOD_INCREASE);
    }
}