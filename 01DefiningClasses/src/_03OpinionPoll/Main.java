package _03OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 14:54 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] input = bufferedReader.readLine()
                    .split("\\s+");

            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name,age);

            people.add(person);
        }

        people.stream()
                .filter(p->p.getAge()>30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}