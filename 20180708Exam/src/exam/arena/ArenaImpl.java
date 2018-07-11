package exam.arena;

import exam.characters.ComicCharacter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 09:53 ч.
 */
public class ArenaImpl implements Arena {

    private String arenaName;
    private List<ComicCharacter> heroes;
    private List<ComicCharacter> antiHeroes;
    private int capacity;

    public ArenaImpl(String arenaName, int capacity) {
        setArenaName(arenaName);
        this.heroes = new ArrayList<>();
        this.antiHeroes = new ArrayList<>();
        setCapacity(capacity);
    }

    private void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<ComicCharacter> getHeroes() {
        return Collections.unmodifiableList(heroes);
    }

    public List<ComicCharacter> getAntiHeroes() {
        return Collections.unmodifiableList(antiHeroes);
    }

    @Override
    public String getArenaName() {
        return this.arenaName;
    }

    @Override
    public boolean isArenaFull() {
        return heroes.size() + antiHeroes.size() >= capacity;
    }

    @Override
    public void addHero(ComicCharacter hero) {
        this.heroes.add(hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
        this.antiHeroes.add(antiHero);
    }

    @Override
    public boolean fightHeroes() {

        List<ComicCharacter> firstFighters = null;
        List<ComicCharacter> secondFighters = null;
        final String heroesString = "heroes";
        final String antiheroesString = "antiHeroes";

        String firstCharType;

        if (heroes.size() >= antiHeroes.size()) {
            firstFighters = antiHeroes;
            secondFighters = heroes;
            firstCharType = antiheroesString;
        } else {
            firstFighters = heroes;
            secondFighters = antiHeroes;
            firstCharType = heroesString;
        }

        while (true) {

            int endIndex;

            endIndex = Math.min(firstFighters.size(), secondFighters.size());

            for (int i = 0; i < endIndex; i++) {
                secondFighters.get(i)
                        .takeDamage(firstFighters.get(i)
                                .attack());
            }

            secondFighters = secondFighters.stream()
                    .filter(f -> f.getHealth() > 0)
                    .collect(Collectors.toList());

            if (secondFighters.size() == 0) {
                switch (firstCharType) {
                    case heroesString:
                        antiHeroes = secondFighters;
                        break;
                    case antiheroesString:
                        heroes = secondFighters;
                        break;
                }
                break;
            }

            endIndex = Math.min(firstFighters.size(), secondFighters.size());
            for (int i = 0; i < endIndex; i++) {
                firstFighters.get(i)
                        .takeDamage(secondFighters.get(i)
                                .attack());
            }

            firstFighters = firstFighters.stream()
                    .filter(f -> f.getHealth() > 0)
                    .collect(Collectors.toList());

            if (firstFighters.size() == 0) {
                switch (firstCharType) {
                    case heroesString:
                        heroes = firstFighters;
                        break;
                    case antiheroesString:
                        antiHeroes = firstFighters;
                        break;
                }
                break;
            }
        }

        if (heroes.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
}