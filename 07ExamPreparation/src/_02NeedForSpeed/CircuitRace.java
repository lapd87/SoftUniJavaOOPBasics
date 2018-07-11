package _02NeedForSpeed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.7.2018 г.
 * Time: 09:46 ч.
 */
public class CircuitRace extends Race {

    private int laps;

    public CircuitRace(int id, int length, String route,
                       int prizePool, int laps) {
        super(id, length, route, prizePool);
        this.laps = laps;
    }

    private void decreaseDurability(Car car) {
        getParticipants()
                .forEach(c -> c.setDurability(c.getDurability()
                        - super.getLength() * super.getLength()));
    }

    @Override
    public int getCarPerformancePoints(Car car) {
        return car.getHorsepower() / car.getAcceleration()
                + car.getSuspension() + car.getDurability();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s - %d",
                super.getRoute(), getLength() * laps));

        List<Car> winners = getParticipants();

        winners.forEach(this::decreaseDurability);

        winners = winners.stream()
                .sorted(Comparator
                        .comparing(this::getCarPerformancePoints)
                        .reversed())
                .limit(4)
                .collect(Collectors.toList());

        List<Integer> prizePoolPercentage = new ArrayList<Integer>() {{
            add(40);
            add(30);
            add(20);
            add(10);
        }};

        for (int i = 0; i < winners.size(); i++) {
            Car currentCar = winners.get(i);
            int moneyWon = getPrizePool() * prizePoolPercentage.get(i) / 100;

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