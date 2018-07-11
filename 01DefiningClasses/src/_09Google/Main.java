package _09Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.6.2018 г.
 * Time: 10:00 ч.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap<>();

        String input;
        while (!"End".equals(input = bufferedReader.readLine())) {

            String[] inputArgs = input.split("\\s+");

            String personName = inputArgs[0];

            Person person = null;

            if (people.containsKey(personName)) {
                person = people.get(personName);
            } else {
                person = new Person(personName);
            }

            switch (inputArgs[1]) {
                case "company":
                    addCompany(inputArgs, person);
                    break;
                case "pokemon":
                    addPokemon(inputArgs, person);
                    break;
                case "parents":
                    addParent(inputArgs, person);
                    break;
                case "children":
                    addChild(inputArgs, person);
                    break;
                case "car":
                    addCar(inputArgs, person);
                    break;
            }

            people.put(personName, person);
        }

        input = bufferedReader.readLine();

        System.out.print(people.get(input));
    }

    private static void addCar(String[] inputArgs, Person person) {
        String carModel = inputArgs[2];
        String carSpeed = inputArgs[3];

        Car car = new Car(carModel, carSpeed);

        person.setCar(car);
    }

    private static void addChild(String[] inputArgs, Person person) {
        String childName = inputArgs[2];
        String childBirthday = inputArgs[3];

        Relative child = new Relative(childName,
                childBirthday);

        person.getChildren().add(child);
    }

    private static void addParent(String[] inputArgs, Person person) {
        String parentName = inputArgs[2];
        String parentBirthday = inputArgs[3];

        Relative parent = new Relative(parentName,
                parentBirthday);

        person.getParents().add(parent);
    }

    private static void addPokemon(String[] inputArgs, Person person) {
        String pokemonName = inputArgs[2];
        String pokemonType = inputArgs[3];

        Pokemon pokemon = new Pokemon(pokemonName,
                pokemonType);

        person.getPokemon().add(pokemon);
    }

    private static void addCompany(String[] inputArgs, Person person) {
        String companyName = inputArgs[2];
        String companyDepartment = inputArgs[3];
        double companySalary = Double.parseDouble(inputArgs[4]);

        Company company = new Company(companyName,
                companyDepartment, companySalary);

        person.setCompany(company);
    }
}