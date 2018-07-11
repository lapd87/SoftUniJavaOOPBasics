package _06BirthdayCelebrations;

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

        List<Birthable> birthables = new ArrayList<>();

        String input;
        while (!"End".equals(input = bufferedReader.readLine())) {

            String[] inputData = input.split("\\s+");
            String identifiableType = inputData[0];

            Birthable birthable = null;
            switch (identifiableType) {
                case "Citizen":
                    birthable = new Citizen(inputData[1],
                            Integer.parseInt(inputData[2]),
                            inputData[3], inputData[4]);
                    break;
                case "Pet":
                    birthable = new Pet(inputData[1],
                            inputData[2]);
                    break;
                default:
                    continue;
            }

            birthables.add(birthable);
        }

        String birthdayYear = bufferedReader.readLine();

        birthables
                .stream()
                .filter(b -> b.getBirthday().endsWith(birthdayYear))
                .forEach(b -> System.out.println(b.getBirthday()));
    }
}