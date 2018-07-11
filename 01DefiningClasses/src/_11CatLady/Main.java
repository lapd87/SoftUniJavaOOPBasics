package _11CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.6.2018 г.
 * Time: 14:45 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        List<Cat> cats = new ArrayList<>();

        String input;
        while (!"End".equals(input = bufferedReader.readLine())) {
            String[] inputArgs = input.split("\\s+");

            String breed = inputArgs[0];
            String name = inputArgs[1];
            double specialFeature = Double.parseDouble(inputArgs[2]);

            Cat cat = null;
            switch (breed) {
                case "Siamese":
                    cat = new Siamese(name, specialFeature);
                    break;
                case "Cymric":
                    cat = new Cymric(name, specialFeature);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, specialFeature);
                    break;
            }

            cats.add(cat);
        }

        String searchedCat = bufferedReader.readLine();

        cats.stream()
                .filter(c -> searchedCat.equals(c.getName()))
                .forEach(System.out::println);
    }
}