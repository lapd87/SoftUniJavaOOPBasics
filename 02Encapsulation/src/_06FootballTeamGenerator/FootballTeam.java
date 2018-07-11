package _06FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static _06FootballTeamGenerator.DefaultExceptionMessages.DEFAULT_ILLEGAL_NAME_EXCEPTION_MESSAGE;
import static _06FootballTeamGenerator.DefaultExceptionMessages.DEFAULT_MISSING_PLAYER_MESSAGE;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.6.2018 г.
 * Time: 16:43 ч.
 */
public class FootballTeam {

    private List<Player> players;
    private String name;
    private int rating;

    public FootballTeam() {
        this.players = new ArrayList<>();
    }

    public FootballTeam(String name) {
        this();
        setName(name);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(DEFAULT_ILLEGAL_NAME_EXCEPTION_MESSAGE);
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    private void setRating() {
        this.rating = (int) Math.round(getPlayers().stream()
                .mapToDouble(Player::getOverallSkill)
                .average()
                .orElse(0));
    }

    public int getRating() {
        setRating();
        return rating;
    }

    private List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        getPlayers().add(player);
    }

    public void removePlayer(String playerName) {

        List<Player> player = getPlayers().stream()
                .filter(p -> playerName.equals(p.getName()))
                .collect(Collectors.toList());

        if (player.isEmpty()) {
            throw new IllegalArgumentException(String
                    .format(DEFAULT_MISSING_PLAYER_MESSAGE,
                            playerName, name));
        } else {
            getPlayers().remove(player.get(0));
        }
    }
}