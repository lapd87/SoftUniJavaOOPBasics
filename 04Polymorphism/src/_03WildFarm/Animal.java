package _03WildFarm;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 26.6.2018 г.
 * Time: 10:19 ч.
 */
public abstract class Animal {

    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    public abstract void makeSound();

    public abstract void eat(Food food);

    public Animal() {
        setFoodEaten(0);
    }

    public Animal(String animalName, String animalType,
                  Double animalWeight) {
        this();
        setAnimalName(animalName);
        setAnimalType(animalType);
        setAnimalWeight(animalWeight);
    }

    public String getAnimalName() {
        return animalName;
    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    private void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    private void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

}