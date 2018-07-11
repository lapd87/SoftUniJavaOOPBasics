package _04MordorsCrueltyPlan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 14:14 ч.
 */
public class Gandalf {

    private static final Map<String, Integer> DEFAULT_FOODS = new HashMap<String, Integer>() {{
        put("cram", 2);
        put("lembas", 3);
        put("apple", 1);
        put("melon", 1);
        put("honeycake", 5);
        put("mushrooms", -10);
    }};
    private static final int BASE_FOOD_MOOD_POINTS = -1;

    private int moodPoints;

    public Gandalf() {
        this.moodPoints = 0;
    }

    public void eat(String food) {

        if (DEFAULT_FOODS.containsKey(food.toLowerCase())) {
            moodPoints += DEFAULT_FOODS.get(food.toLowerCase());
        } else {
            moodPoints += BASE_FOOD_MOOD_POINTS;
        }
    }

    private int getMoodPoints() {
        return moodPoints;
    }

    private String getMood() {
        int moodPoints = getMoodPoints();

        if (moodPoints < -5) {
            return "Angry";
        } else if (moodPoints < 0) {
            return "Sad";
        } else if (moodPoints < 15) {
            return "Happy";
        } else {
            return "JavaScript";
        }
    }

    @Override
    public String toString() {
        return String.format("%d%n%s",
                getMoodPoints(),
                getMood());
    }
}