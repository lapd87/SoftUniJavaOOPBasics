package _07FoodShortage;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 12:58 ч.
 */
public class Citizen implements Feedable {

    private final int DEFAULT_CITIZEN_FOOD_INCREASE = 10;

    private String name;
    private int age;
    private String id;
    private String birthday;
    private int foodQuantity;

    public Citizen(String name, int age, String id, String birthday) {
        setName(name);
        setAge(age);
        setId(id);
        setBirthday(birthday);
        setFoodQuantity(0);
    }

    @Override
    public int getFoodQuantity() {
        return foodQuantity;
    }

    private void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }


    @Override
    public void buyFood() {
        setFoodQuantity(getFoodQuantity() + DEFAULT_CITIZEN_FOOD_INCREASE);
    }
}