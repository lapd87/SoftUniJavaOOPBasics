package _06BirthdayCelebrations;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 13:12 ч.
 */
public class Pet implements Birthable {

    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        setName(name);
        setBirthday(birthday);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}