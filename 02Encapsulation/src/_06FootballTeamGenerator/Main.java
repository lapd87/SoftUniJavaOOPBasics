package _06FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static _06FootballTeamGenerator.DefaultExceptionMessages.DEFAULT_MISSING_TEAM_MESSAGE;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.6.2018 г.
 * Time: 17:15 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        List<FootballTeam> teams = new ArrayList<>();

        String input;
        while (!"END".equals(input = bufferedReader.readLine())) {

            String[] inputArgs = input.split(";");

            String command = inputArgs[0];
            String teamName = inputArgs[1];

            if (!command.equals("Team")
                    && teams.stream()
                    .noneMatch(t -> teamName
                            .equals(t.getName()))) {
                System.out.printf(DEFAULT_MISSING_TEAM_MESSAGE,
                        teamName);
                continue;
            }

            try {
                switch (command) {
                    case "Team":
                        FootballTeam team = new FootballTeam(teamName);
                        teams.add(team);
                        break;
                    case "Add":
                        String playerName = inputArgs[2];
                        int playerEndurance = Integer.parseInt(inputArgs[3]);
                        int playerSprint = Integer.parseInt(inputArgs[4]);
                        int playerDribble = Integer.parseInt(inputArgs[5]);
                        int playerPassing = Integer.parseInt(inputArgs[6]);
                        int playerShooting = Integer.parseInt(inputArgs[7]);

                        Player player = new Player(playerName,
                                playerEndurance, playerSprint,
                                playerDribble, playerPassing,
                                playerShooting);

                        teams.stream()
                                .filter(t -> teamName.equals(t.getName()))
                                .findFirst()
                                .ifPresent(t -> t.addPlayer(player));
                        break;
                    case "Remove":
                        playerName = inputArgs[2];

                        teams.stream()
                                .filter(t -> teamName.equals(t.getName()))
                                .forEach(t -> t.removePlayer(playerName));
                        break;
                    case "Rating":
                        teams.stream()
                                .filter(t -> teamName.equals(t.getName()))
                                .forEach(t -> System.out.printf("%s - %d%n",
                                        teamName, t.getRating()));
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.printf(iae.getMessage());
            }
        }

    }
}