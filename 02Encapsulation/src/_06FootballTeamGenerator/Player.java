package _06FootballTeamGenerator;

import static _06FootballTeamGenerator.DefaultExceptionMessages.DEFAULT_ILLEGAL_NAME_EXCEPTION_MESSAGE;
import static _06FootballTeamGenerator.DefaultExceptionMessages.DEFAULT_ILLEGAL_STAT_EXCEPTION_MESSAGE;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.6.2018 г.
 * Time: 16:43 ч.
 */
public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;
    private double overallSkill;

    public Player() {
    }

    public Player(String name, int endurance,
                  int sprint, int dribble, int passing,
                  int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(DEFAULT_ILLEGAL_NAME_EXCEPTION_MESSAGE);
        } else {
            this.name = name;
        }
    }

    private void setEndurance(int endurance) {
        if (endurance < 0 || endurance > 100) {
            throw new IllegalArgumentException(String
                    .format(DEFAULT_ILLEGAL_STAT_EXCEPTION_MESSAGE, "Endurance"));
        } else {
            this.endurance = endurance;
        }
    }

    private void setSprint(int sprint) {
        if (sprint < 0 || sprint > 100) {
            throw new IllegalArgumentException(String
                    .format(DEFAULT_ILLEGAL_STAT_EXCEPTION_MESSAGE, "Sprint"));
        } else {
            this.sprint = sprint;
        }
    }

    private void setDribble(int dribble) {
        if (dribble < 0 || dribble > 100) {
            throw new IllegalArgumentException(String
                    .format(DEFAULT_ILLEGAL_STAT_EXCEPTION_MESSAGE, "Dribble"));
        } else {
            this.dribble = dribble;
        }
    }

    private void setPassing(int passing) {
        if (passing < 0 || passing > 100) {
            throw new IllegalArgumentException(String.format(DEFAULT_ILLEGAL_STAT_EXCEPTION_MESSAGE, "Passing"));
        } else {
            this.passing = passing;
        }
    }

    private void setShooting(int shooting) {
        if (shooting < 0 || shooting > 100) {
            throw new IllegalArgumentException(String.format(DEFAULT_ILLEGAL_STAT_EXCEPTION_MESSAGE, "Shooting"));
        } else {
            this.shooting = shooting;
        }
    }

    public String getName() {
        return name;
    }

    private int getEndurance() {
        return endurance;
    }

    private int getSprint() {
        return sprint;
    }

    private int getDribble() {
        return dribble;
    }

    private int getPassing() {
        return passing;
    }

    private int getShooting() {
        return shooting;
    }

    public double getOverallSkill() {
        return (getEndurance() + getSprint() + getDribble()
                + getPassing() + getShooting()) / 5.0;
    }
}