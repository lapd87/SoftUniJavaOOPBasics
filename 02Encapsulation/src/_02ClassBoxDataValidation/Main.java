package _02ClassBoxDataValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.6.2018 г.
 * Time: 12:20 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        double length = Double.parseDouble(bufferedReader.readLine());
        double width = Double.parseDouble(bufferedReader.readLine());
        double height = Double.parseDouble(bufferedReader.readLine());

        try {
            Box box = new Box(length, width, height);
            System.out.print(box.toString());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}