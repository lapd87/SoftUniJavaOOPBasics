package _06Animals;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 21.6.2018 г.
 * Time: 09:35 ч.
 */
public class Animal extends SoundProducable {

    public static final String INVALID_INPUT_MESSAGE = "Invalid input!";

    private String name;
    private int age;
    private String gender;

    public Animal() {
    }

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        this.age = age;
    }

    public void setGender(String gender) {
        if (!gender.equals("Female") && !gender.equals("Male")) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        this.gender = gender;
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    private String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name)
                .append(" ")
                .append(age)
                .append(" ")
                .append(gender);

        return stringBuilder.toString();
    }
}