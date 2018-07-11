package exam.arena;

import exam.characters.ComicCharacter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 09:53 ч.
 */
public interface Arena {

    String getArenaName();

    boolean isArenaFull();

    void addHero(ComicCharacter hero);

    void addAntiHero(ComicCharacter antiHero);

    boolean fightHeroes();

    List<ComicCharacter> getHeroes();

    List<ComicCharacter> getAntiHeroes();
}
