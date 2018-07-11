package _004SayHelloExtended;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 11:19 ч.
 */
public class Bulgarian extends BasePerson {

    private String name;

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}