package _07FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 13:02 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Map<String, Feedable> feedables = new HashMap<>();

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputData = bufferedReader.readLine()
                    .split("\\s+");

            Feedable feedable = null;
            if (inputData.length == 3) {
                feedable = new Rebel(inputData[0],
                        Integer.parseInt(inputData[1]),
                        inputData[2]);
            } else if (inputData.length == 4) {
                feedable = new Citizen(inputData[0],
                        Integer.parseInt(inputData[1]),
                        inputData[2], inputData[3]);
            } else {
                continue;
            }

            feedables.put(inputData[0], feedable);
        }

        String input;
        while (!"End".equals(input = bufferedReader.readLine())) {
            if (feedables.containsKey(input)) {
                feedables.get(input).buyFood();
            }
        }

        int totalFoodQuantity = feedables.values()
                .stream()
                .mapToInt(Feedable::getFoodQuantity)
                .sum();

        System.out.println(totalFoodQuantity);
    }
}