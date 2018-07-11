package _03Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 27.6.2018 г.
 * Time: 12:00 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException, IllegalClassFormatException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String driverName = bufferedReader.readLine();

        Car car = new Ferrari(driverName);

        System.out.println(car);

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
    }
}