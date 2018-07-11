package _06BirthdayCelebrations;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 12:58 ч.
 */
public class Citizen implements Identifiable,Birthable {

    private String name;
    private int age;
    private String id;
    private String birthday;

    public Citizen(String name, int age, String id, String birthday) {
        setName(name);
        setAge(age);
        setId(id);
        setBirthday(birthday);
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}