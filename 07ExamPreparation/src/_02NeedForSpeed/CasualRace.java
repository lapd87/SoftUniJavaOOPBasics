package _02NeedForSpeed;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.7.2018 г.
 * Time: 10:15 ч.
 */
public class CasualRace extends Race {

    public CasualRace(int id, int length, String route, int prizePool) {
        super(id, length, route, prizePool);
    }

    @Override
    public int getCarPerformancePoints(Car car) {
        return car.getHorsepower() / car.getAcceleration()
                + car.getSuspension() + car.getDurability();
    }
}