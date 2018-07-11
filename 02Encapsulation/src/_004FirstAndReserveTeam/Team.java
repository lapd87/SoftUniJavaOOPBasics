package _004FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.6.2018 г.
 * Time: 10:38 ч.
 */
public class Team {

    private String name;
    private List<Person> firstTeamPlayers;
    private List<Person> reserveTeamPlayers;

    public Team() {
        this.firstTeamPlayers = new ArrayList<>();
        this.reserveTeamPlayers = new ArrayList<>();
    }

    public Team(String name) {
        this();
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addPlayer(Person person) {

        if (person.getAge() < 40) {
            firstTeamPlayers.add(person);
        } else {
            reserveTeamPlayers.add(person);
        }
    }

    public List<Person> getFirstTeamPlayers() {
        return Collections.unmodifiableList(firstTeamPlayers);
    }

    public List<Person> getReserveTeamPlayers() {
        return Collections.unmodifiableList(reserveTeamPlayers);
    }
}