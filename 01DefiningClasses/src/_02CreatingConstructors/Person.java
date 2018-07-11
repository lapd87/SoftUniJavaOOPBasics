package _02CreatingConstructors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 14:47 ч.
 */
public class Person {

    private static final String DEFAULT_NAME = "No name";
    private static final int DEFAULT_AGE = 1;

    private String name;
    private int age;

    public Person() {
        this(DEFAULT_NAME, DEFAULT_AGE);
    }

    public Person(int age) {
        this(DEFAULT_NAME, age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}