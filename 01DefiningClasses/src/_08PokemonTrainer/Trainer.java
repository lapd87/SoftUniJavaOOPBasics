package _08PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 21:21 ч.
 */
public class Trainer {

    private static final int DEFAULT_BADGES_COUNT = 0;

    private String name;
    private int badgesCount;
    private List<Pokemon> pokemons;

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
        this.badgesCount = DEFAULT_BADGES_COUNT;
        this.pokemons = new ArrayList<>();
    }

    public Trainer(String name, Pokemon pokemon) {
        this(name);
        this.getPokemons().add(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addBadge() {
        this.badgesCount++;
    }

    public int getBadgesCount() {
        return badgesCount;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",
                name, badgesCount, getPokemons().size());
    }
}