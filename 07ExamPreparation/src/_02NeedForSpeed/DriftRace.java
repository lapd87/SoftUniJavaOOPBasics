package _02NeedForSpeed;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.7.2018 г.
 * Time: 10:16 ч.
 */
public class DriftRace extends Race {

    public DriftRace(int id, int length, String route, int prizePool) {
        super(id, length, route, prizePool);
    }

    @Override
    public int getCarPerformancePoints(Car car) {
        return car.getSuspension() + car.getDurability();
    }
}