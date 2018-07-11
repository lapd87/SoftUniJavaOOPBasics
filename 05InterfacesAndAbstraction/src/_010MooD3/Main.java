package _010MooD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.7.2018 г.
 * Time: 13:20 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine()
                .split("\\s+\\|\\s+");

        String username = input[0];
        String characterType = input[1];
        int level = Integer.parseInt(input[3]);

        GameObject gameObject = null;

        switch (characterType) {
            case "Demon":
                double energy = Double.parseDouble(input[2]);
                gameObject = new Demon(username, level, energy);
                break;
            case "Archangel":
                int mana = Integer.parseInt(input[2]);
                gameObject = new Archangel(username, level, mana);
        }

        System.out.println(gameObject);
    }
}