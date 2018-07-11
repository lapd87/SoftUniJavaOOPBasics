package _04MordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 14:17 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String[] foods = bufferedReader.readLine()
                .split("\\s+");

        Gandalf gandalf = new Gandalf();

        for (String food : foods) {
            gandalf.eat(food);
        }

        System.out.println(gandalf);

    }
}