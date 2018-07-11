package _02NeedForSpeed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.7.2018 г.
 * Time: 10:16 ч.
 */
public class Garage {

    private List<Car> parkedCars;

    public Garage() {
        parkedCars = new ArrayList<>();
    }

    public void modify(int tuneIndex, String addOn) {
        parkedCars.forEach(c -> c.tune(tuneIndex, addOn));
    }

    public void parkCar(Car car) {
        if (!parkedCars.contains(car)) {
            parkedCars.add(car);
        }
    }

    public void unparkCar(Car car) {
        parkedCars.remove(car);
    }

    public List<Car> getParkedCars() {
        return Collections.unmodifiableList(parkedCars);
    }
}