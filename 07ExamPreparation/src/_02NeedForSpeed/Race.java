package _02NeedForSpeed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.7.2018 г.
 * Time: 10:14 ч.
 */
public abstract class Race {

    private int id;
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    public Race(int id, int length, String route, int prizePool) {
        this.id = id;
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }

    public int getLength() {
        return length;
    }

    public String getRoute() {
        return route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    public void addParticipant(Car car) {
        participants.add(car);
    }

    public String startRace() {
        return toString();
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public abstract int getCarPerformancePoints(Car car);

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s - %d",
                route, length));

        List<Car> winners = participants.stream()
                .sorted(Comparator
                        .comparing(this::getCarPerformancePoints)
                        .reversed())
                .limit(3)
                .collect(Collectors.toList());

        List<Integer> prizePoolPercentage = new ArrayList<Integer>() {{
            add(50);
            add(30);
            add(20);
        }};

        for (int i = 0; i < winners.size(); i++) {
            Car currentCar = winners.get(i);
            int moneyWon = prizePool * prizePoolPercentage.get(i) / 100;

            stringBuilder
                    .append(System.lineSeparator())
                    .append(String.format("%d. %s %s %dPP - $%d",
                            i + 1,
                            currentCar.getBrand(),
                            currentCar.getModel(),
                            getCarPerformancePoints(currentCar),
                            moneyWon));
        }

        return stringBuilder.toString();
    }
}