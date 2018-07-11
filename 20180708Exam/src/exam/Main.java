package exam;

import exam.arena.Arena;
import exam.arena.ArenaImpl;
import exam.characters.*;
import exam.characters.antihero.Titan;
import exam.characters.antihero.Villain;
import exam.characters.hero.DCHero;
import exam.characters.hero.MarvelHero;
import exam.manager.WarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.7.2018 г.
 * Time: 10:38 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        WarManager warManager = new WarManager();


        String input;
        while (true) {
            if ("WAR_IS_OVER".equals(input = bufferedReader.readLine())) {
                System.out.println(warManager.endWar());
                break;
            }

            String result = "";
            try {
                String[] commandArgs = input.split("\\s+");

                String command = commandArgs[0];

                switch (command) {
                    case "CHECK_CHARACTER":
                        result = warManager.checkComicCharacter(commandArgs[1]);
                        break;
                    case "REGISTER_HERO":
                        ComicCharacter comicCharacter = null;

                        String type = commandArgs[2];
                        switch (type) {
                            case "DCHero":
                                comicCharacter = new DCHero(commandArgs[1],
                                        Integer.parseInt(commandArgs[3]),
                                        Double.parseDouble(commandArgs[4]),
                                        Double.parseDouble(commandArgs[5]),
                                        Double.parseDouble(commandArgs[6]));
                                break;
                            case "MarvelHero":
                                comicCharacter = new MarvelHero(commandArgs[1],
                                        Integer.parseInt(commandArgs[3]),
                                        Double.parseDouble(commandArgs[4]),
                                        Double.parseDouble(commandArgs[5]),
                                        Double.parseDouble(commandArgs[6]));
                                break;
                        }

                        result = warManager.addHero(comicCharacter);
                        break;
                    case "REGISTER_ANTI_HERO":
                        comicCharacter = null;

                        type = commandArgs[2];
                        switch (type) {
                            case "Villain":
                                comicCharacter = new Villain(commandArgs[1],
                                        Integer.parseInt(commandArgs[3]),
                                        Double.parseDouble(commandArgs[4]),
                                        Double.parseDouble(commandArgs[5]),
                                        Double.parseDouble(commandArgs[6]));
                                break;
                            case "Titan":
                                comicCharacter = new Titan(commandArgs[1],
                                        Integer.parseInt(commandArgs[3]),
                                        Double.parseDouble(commandArgs[4]),
                                        Double.parseDouble(commandArgs[5]),
                                        Double.parseDouble(commandArgs[6]));
                                break;
                        }

                        result = warManager.addAntiHero(comicCharacter);
                        break;
                    case "BUILD_ARENA":
                        Arena arena = new ArenaImpl(commandArgs[1],
                                Integer.parseInt(commandArgs[2]));

                        result = warManager.addArena(arena);
                        break;
                    case "SEND_HERO":
                        result = warManager.addHeroToArena(commandArgs[1],
                                commandArgs[2]);
                        break;
                    case "SEND_ANTI_HERO":
                        result = warManager.addAntiHeroToArena(commandArgs[1],
                                commandArgs[2]);
                        break;
                    case "SUPER_POWER":
                        SuperPower superPower = new Power(commandArgs[1],
                                Double.parseDouble(commandArgs[2]));

                        result = warManager.loadSuperPowerToPool(superPower);
                        break;
                    case "ASSIGN_POWER":
                        result = warManager.assignSuperPowerToComicCharacter(commandArgs[1],
                                commandArgs[2]);
                        break;
                    case "UNLEASH":
                        result = warManager.usePowers(commandArgs[1]);
                        break;
                    case "COMICS_WAR":
                        result = warManager.startBattle(commandArgs[1]);
                        break;
                }

                if (result != null) {
                    System.out.println(result);
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}