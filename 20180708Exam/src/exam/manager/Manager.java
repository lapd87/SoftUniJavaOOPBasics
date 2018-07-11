package exam.manager;

import exam.arena.Arena;
import exam.characters.ComicCharacter;
import exam.characters.SuperPower;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 10:26 ч.
 */
public interface Manager {
    String checkComicCharacter(String characterName);

    String addHero(ComicCharacter hero);

    String addAntiHero(ComicCharacter antiHero);

    String addArena(Arena arena);

    String addHeroToArena(String arenaName, String heroName);

    String addAntiHeroToArena(String arenaName, String antiHeroName);

    String loadSuperPowerToPool(SuperPower superPower);

    String assignSuperPowerToComicCharacter(String comicCharacterName, String superPowerName);

    String usePowers(String characterName);

    String startBattle(String arenaName);

    String endWar();
}
