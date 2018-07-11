package _05BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

        List<Identifiable> identifiables = new ArrayList<>();

        String input;
        while (!"End".equals(input = bufferedReader.readLine())) {

            String[] inputData = input.split("\\s+");

            Identifiable identifiable = null;
            if (inputData.length == 2) {
                identifiable = new Robot(inputData[0], inputData[1]);
            } else if (inputData.length == 3) {
                identifiable = new Citizen(inputData[0],
                        Integer.parseInt(inputData[1]), inputData[2]);
            } else {
                continue;
            }

            identifiables.add(identifiable);
        }

        String fakeIdLastDigits = bufferedReader.readLine();

        identifiables
                .stream()
                .filter(i -> i.getId().endsWith(fakeIdLastDigits))
                .forEach(i -> System.out.println(i.getId()));
    }
}