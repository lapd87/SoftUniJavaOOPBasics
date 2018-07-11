package _06Animals;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 21.6.2018 г.
 * Time: 09:36 ч.
 */
public class Tomcat extends Cat {

    public Tomcat() {
    }

    @Override
    public void setGender(String gender) {
        if (!gender.equals("Male")){
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}