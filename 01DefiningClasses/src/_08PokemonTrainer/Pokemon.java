package _08PokemonTrainer;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 21:22 ч.
 */
public class Pokemon {

    private String name;
    private String element;
    private int health;

    public Pokemon() {
    }

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public void decreaseHealthBy10() {
        this.health -= 10;
    }

    public int getHealth() {
        return health;
    }
}