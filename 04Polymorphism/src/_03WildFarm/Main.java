package _03WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.6.2018 г.
 * Time: 10:22 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String input;
        while (true) {
            if ("End".equals(input = bufferedReader.readLine())) {
                break;
            }

            try {
                String[] animalData = input.split("\\s+");
                String[] foodData = bufferedReader.readLine()
                        .split("\\s+");

                Animal animal = setAnimal(animalData);
                animal.makeSound();

                Food food = setFood(foodData);

                try {
                    animal.eat(food);
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }

                animals.add(animal);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private static Food setFood(String[] foodData) {
        String foodType = foodData[0];
        Integer foodQuantity = Integer.parseInt(foodData[1]);

        Food food = null;
        switch (foodType) {
            case "Vegetable":
                food = new Vegetable(foodQuantity);
                break;
            case "Meat":
                food = new Meat(foodQuantity);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return food;
    }

    private static Animal setAnimal(String[] animalData) {
        String animalType = animalData[0];
        String animalName = animalData[1];
        Double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivingRegion = animalData[3];

        Animal animal = null;

        switch (animalType) {
            case "Mouse":
                animal = new Mouse(animalName, animalType,
                        animalWeight, animalLivingRegion);
                break;
            case "Cat":
                String catBreed = animalData[4];
                animal = new Cat(animalName, animalType,
                        animalWeight, animalLivingRegion,
                        catBreed);
                break;
            case "Tiger":
                animal = new Tiger(animalName, animalType,
                        animalWeight, animalLivingRegion);
                break;
            case "Zebra":
                animal = new Zebra(animalName, animalType,
                        animalWeight, animalLivingRegion);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return animal;
    }
}