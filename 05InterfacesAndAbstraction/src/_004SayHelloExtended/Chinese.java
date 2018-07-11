package _004SayHelloExtended;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 11:21 ч.
 */
public class Chinese extends BasePerson {

    private String name;

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}