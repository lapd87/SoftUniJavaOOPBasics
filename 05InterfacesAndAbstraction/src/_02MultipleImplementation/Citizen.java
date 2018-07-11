package _02MultipleImplementation;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 11:48 ч.
 */
public class Citizen implements Person,Identifiable,Birthable {

    private String name;
    private int age;
    private String id;
    private String birthday;

    public Citizen(String name, int age,
                   String id, String birthday) {
        setName(name);
        setAge(age);
        setId(id);
        setBirthday(birthday);
    }

    private void setId(String id) {
        this.id = id;
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

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }
}