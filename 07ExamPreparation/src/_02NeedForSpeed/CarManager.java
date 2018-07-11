package _02NeedForSpeed;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.7.2018 г.
 * Time: 11:41 ч.
 */
public class CarManager {

    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        cars = new LinkedHashMap<>();
        races = new LinkedHashMap<>();
        garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int
            acceleration, int suspension, int durability) {

        Car car = null;

        switch (type) {
            case "Performance":
                car = new PerformanceCar(id, brand, model,
                        yearOfProduction, horsepower,
                        acceleration, suspension,
                        durability);
                break;
            case "Show":
                car = new ShowCar(id, brand, model,
                        yearOfProduction, horsepower,
                        acceleration, suspension,
                        durability);
                break;
        }

        if (car != null) {
            cars.putIfAbsent(id, car);
        }
    }

    public String check(int id) {

        if (cars.containsKey(id)) {
            return cars.get(id).toString();
        }

        if (garage.getParkedCars()
                .stream()
                .anyMatch(c -> c.getId() == id)) {
            return garage.getParkedCars()
                    .stream()
                    .filter(c -> c.getId() == id)
                    .findFirst()
                    .get()
                    .toString();
        }

        return null;
    }

    public void open(int id, String type, int length, String route, int prizePool, String[] commandArgs) {

        Race race = null;

        switch (type) {
            case "Casual":
                race = new CasualRace(id, length, route, prizePool);
                break;
            case "Drag":
                race = new DragRace(id, length, route, prizePool);
                break;
            case "Drift":
                race = new DriftRace(id, length, route, prizePool);
                break;
            case "TimeLimit":
                race = new TimeLimitRace(id, length, route, prizePool, Integer.parseInt(commandArgs[6]));
                break;
            case "Circuit":
                race = new CircuitRace(id, length, route, prizePool, Integer.parseInt(commandArgs[6]));
                break;
        }

        if (race != null) {
            races.putIfAbsent(id, race);
        }

    }

    public void participate(int carId, int raceId) {

        Car car = cars.getOrDefault(carId, null);
        Race race = races.getOrDefault(raceId, null);

        if (car != null && race != null) {

            String raceType = race.getClass().getSimpleName();

            boolean canAddParticipant = true;

            if (raceType.equals("TimeLimit")
                    || raceType.equals("Circuit")) {
                canAddParticipant = race.getParticipants().size() == 0;
            }

            if (canAddParticipant) {
                race.addParticipant(car);
            }
        }
    }

    public String start(int id) {

        Race race = races.getOrDefault(id, null);

        if (race == null) {
            return null;
        }

        if (race.getParticipants().size() == 0) {
            return "Cannot start the race with zero participants.";
        }

        races.remove(id);

        return race.startRace();
    }

    public void park(int id) {

        Car car = cars.getOrDefault(id, null);

        if (car != null) {
            boolean isInRace = races.values()
                    .stream()
                    .anyMatch(r -> r.getParticipants()
                            .contains(car));

            if (!isInRace) {
                garage.parkCar(car);
                cars.remove(car.getId());
            }
        }
    }

    public void unpark(int id) {
        Car car = garage.getParkedCars()
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (car != null) {
            garage.unparkCar(car);
            cars.putIfAbsent(car.getId(), car);
        }
    }


    public void tune(int tuneIndex, String addOn) {
        garage.modify(tuneIndex, addOn);
    }
}