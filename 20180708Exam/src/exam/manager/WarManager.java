package exam.manager;

import exam.arena.Arena;
import exam.characters.ComicCharacter;
import exam.characters.SuperPower;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 10:39 ч.
 */
public class WarManager implements Manager {

    private Map<String, ComicCharacter> heroes;
    private Map<String, ComicCharacter> antiHeroes;
    private Map<String, Arena> arenas;
    private Map<String, SuperPower> superPowers;
    private int heroesWonBattles;
    private int antiHeroesWonBattles;

    public WarManager() {
        this.heroes = new LinkedHashMap<>();
        this.antiHeroes = new LinkedHashMap<>();
        this.arenas = new LinkedHashMap<>();
        this.superPowers = new LinkedHashMap<>();
        heroesWonBattles = 0;
        antiHeroesWonBattles = 0;
    }

    @Override
    public String checkComicCharacter(String characterName) {

        ComicCharacter comicCharacter = null;

        if (heroes.containsKey(characterName)) {
            comicCharacter = heroes.get(characterName);
        } else if (antiHeroes.containsKey(characterName)) {
            comicCharacter = antiHeroes.get(characterName);
        }

        if (comicCharacter != null) {
            if (comicCharacter.getHealth() <= 0) {
                return String.format("%s has fallen in battle!",
                        characterName);
            } else {
                return comicCharacter.toString();
            }
        }

        return String.format("Sorry, fans! %s doesn't exist in our comics!",
                characterName);
    }

    @Override
    public String addHero(ComicCharacter hero) {

        String heroName = hero.getName();

        if (heroes.containsKey(heroName)) {
            heroes
                    .get(heroName)
                    .boostCharacter(hero.getEnergy(),
                            hero.getHealth(),
                            hero.getIntelligence());

            return String.format("%s evolved!",
                    heroName);
        }

        heroes.putIfAbsent(heroName, hero);
        return String.format("%s is ready for battle!",
                heroName);
    }

    @Override
    public String addAntiHero(ComicCharacter antiHero) {

        String antiHeroName = antiHero.getName();

        if (antiHeroes.containsKey(antiHeroName)) {
            antiHeroes
                    .get(antiHeroName)
                    .boostCharacter(antiHero.getEnergy(),
                            antiHero.getHealth(),
                            antiHero.getIntelligence());

            return String.format("%s is getting stronger!",
                    antiHeroName);
        }

        antiHeroes.putIfAbsent(antiHeroName, antiHero);
        return String.format("%s is ready for destruction!",
                antiHeroName);
    }

    @Override
    public String addArena(Arena arena) {
        String arenaName = arena.getArenaName();

        if (arenas.containsKey(arenaName)) {
            return "A battle is about to start there!";
        }

        arenas.putIfAbsent(arenaName, arena);
        return String.format("%s is becoming a fighting ground!",
                arenaName);
    }

    @Override
    public String addHeroToArena(String arenaName, String heroName) {

        List<ComicCharacter> heroesList = new ArrayList<>();

        arenas.values()
                .forEach(a -> heroesList
                        .addAll(a.getHeroes()));

        if (heroesList.stream()
                .anyMatch(cc -> heroName.equals(cc.getName()))) {
            return String.format("%s is fighting!",
                    heroName);
        }

        ComicCharacter heroToAdd = heroes.get(heroName);

        if (heroToAdd.getHealth() <= 0) {
            return String.format("%s is dead!",
                    heroName);
        }

        if (arenas.get(arenaName).isArenaFull()) {
            return "Arena is full!";
        }

        arenas.get(arenaName).addHero(heroToAdd);

        return String.format("%s is fighting for your freedom in %s!",
                heroName, arenaName);
    }

    @Override
    public String addAntiHeroToArena(String arenaName, String antiHeroName) {
        List<ComicCharacter> antiHeroesList = new ArrayList<>();

        arenas.values()
                .forEach(a -> antiHeroesList
                        .addAll(a.getAntiHeroes()));

        if (antiHeroesList.stream()
                .anyMatch(cc -> antiHeroName.equals(cc.getName()))) {
            return String.format("%s is fighting!",
                    antiHeroName);
        }

        ComicCharacter antiHeroToAdd = antiHeroes.get(antiHeroName);

        if (antiHeroToAdd.getHealth() <= 0) {
            return String.format("%s is dead!",
                    antiHeroName);
        }

        if (arenas.get(arenaName).isArenaFull()) {
            return "Arena is full!";
        }

        arenas.get(arenaName).addAntiHero(antiHeroToAdd);

        return String.format("%s and his colleagues are trying to take over %s!",
                antiHeroName, arenaName);
    }

    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        String superPowerName = superPower.getName();

        if (superPowers.containsKey(superPowerName)) {
            return "This super power already exists!";
        }

        superPowers.putIfAbsent(superPowerName, superPower);

        return String.format("%s added to pool!",
                superPowerName);
    }

    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacterName, String superPowerName) {

        SuperPower superPower = null;
        if (superPowers.containsKey(superPowerName)) {
            superPower = superPowers.get(superPowerName);
        }

        ComicCharacter comicCharacter = null;
        if (heroes.containsKey(comicCharacterName)) {
            comicCharacter = heroes.get(comicCharacterName);
        } else if (antiHeroes.containsKey(comicCharacterName)) {
            comicCharacter = antiHeroes.get(comicCharacterName);
        }

        if (comicCharacter != null
                && superPower != null) {

            List<SuperPower> superPowerList = new ArrayList<>();

            heroes.values()
                    .forEach(h -> superPowerList.addAll(h.getSuperPowers()));
            antiHeroes.values()
                    .forEach(ah -> superPowerList.addAll(ah.getSuperPowers()));

            if (superPowerList.contains(superPower)) {
                return String.format("%s already assigned!",
                        superPowerName);
            }

            comicCharacter.addSuperPower(superPower);

            return String.format("%s has a new super power!",
                    comicCharacterName);
        }

        return null;
    }

    @Override
    public String usePowers(String characterName) {

        ComicCharacter comicCharacter = null;

        if (heroes.containsKey(characterName)) {
            comicCharacter = heroes.get(characterName);
        } else if (antiHeroes.containsKey(characterName)) {
            comicCharacter = antiHeroes.get(characterName);
        }

        if (comicCharacter != null) {
            return comicCharacter.useSuperPowers();
        }

        return null;
    }

    @Override
    public String startBattle(String arenaName) {

        if (arenas.containsKey(arenaName)) {

            Arena arena = arenas.get(arenaName);

            if (arena.getHeroes().size() == 0
                    && arena.getAntiHeroes().size() == 0) {
                return "SAFE ZONE!";
            }

            String resultWinner;
            if (arena.fightHeroes()) {
                heroesWonBattles++;
                resultWinner = "Heroes";
            } else {
                antiHeroesWonBattles++;
                resultWinner = "Anti Heroes";
            }

            arenas.remove(arenaName);

            return String.format("%s won the battle of %s!",
                    resultWinner, arenaName);
        }

        return null;
    }

    @Override
    public String endWar() {

        if (heroesWonBattles >= antiHeroesWonBattles) {
            return String.format("After %d battles our FRIENDLY HEROES WON!",
                    heroesWonBattles + antiHeroesWonBattles);
        } else {
            return "WE ARE DOOMED!";
        }
    }
}