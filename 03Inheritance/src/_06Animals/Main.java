package _06Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static _06Animals.Animal.INVALID_INPUT_MESSAGE;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 21.6.2018 г.
 * Time: 09:38 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String input;
        while (!"Beast!".equals(input = bufferedReader.readLine())) {

            String[] animalArgs = bufferedReader.readLine()
                    .trim()
                    .split("\\s+");

            try {
                if (animalArgs.length < 3) {
                    throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }

                Animal animal = null;
                switch (input) {
                    case "Cat":
                        animal = new Cat();
                        break;
                    case "Tomcat":
                        animal = new Tomcat();
                        break;
                    case "Kitten":
                        animal = new Kitten();
                        break;
                    case "Dog":
                        animal = new Dog();
                        break;
                    case "Frog":
                        animal = new Frog();
                        break;
                    default:
                        throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }

                String name = animalArgs[0];
                int age = Integer.parseInt(animalArgs[1]);
                String gender = animalArgs[2];

                animal.setName(name);
                animal.setAge(age);
                animal.setGender(gender);

                animals.add(animal);

                System.out.println(input);
                System.out.println(animal);
                System.out.println(animal.produceSound());
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}