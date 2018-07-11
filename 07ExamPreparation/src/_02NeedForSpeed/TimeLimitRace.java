package _02NeedForSpeed;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 6.7.2018 г.
 * Time: 09:45 ч.
 */
public class TimeLimitRace extends Race {

    private int goldTime;

    public TimeLimitRace(int id, int length, String route,
                         int prizePool, int goldTime) {
        super(id, length, route, prizePool);
        this.goldTime = goldTime;
    }

    private String getTimeMedalAndMoneyWon(Car car) {
        int raceTime = getCarPerformancePoints(car);

        String medal = "";
        int prize = 0;
        if (raceTime <= goldTime) {
            medal = "Gold";
            prize = getPrizePool();
        } else if (raceTime <= goldTime + 15) {
            medal = "Silver";
            prize = getPrizePool() * 50 / 100;
        } else {
            medal = "Bronze";
            prize = getPrizePool() * 30 / 100;
        }

        return String.format("%s Time, $%d.",
                medal, prize);
    }

    @Override
    public int getCarPerformancePoints(Car car) {
        return super.getLength() * ((car.getHorsepower() / 100) * car.getAcceleration());
    }

    @Override
    public String toString() {

        Car participant = getParticipants().stream()
                .findFirst()
                .get();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s - %d",
                getRoute(), getLength()))
                .append(System.lineSeparator())
                .append(String.format("%s %s - %d s.",
                        participant.getBrand(),
                        participant.getModel(),
                        getCarPerformancePoints(participant)))
                .append(System.lineSeparator())
                .append(String.format("%s",
                        getTimeMedalAndMoneyWon(participant)));

        return stringBuilder.toString();
    }
}