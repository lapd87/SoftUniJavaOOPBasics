package _02NeedForSpeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.7.2018 г.
 * Time: 10:16 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        CarManager carManager = new CarManager();

        String input;
        while (true) {
            if ("Cops Are Here".equals(input = bufferedReader.readLine())) {
                break;
            }

            String[] commandArgs = input.split("\\s+");

            String command = commandArgs[0];

            switch (command) {
                case "register":
                    carManager.register(Integer.parseInt(commandArgs[1]),
                            commandArgs[2],
                            commandArgs[3],
                            commandArgs[4],
                            Integer.parseInt(commandArgs[5]),
                            Integer.parseInt(commandArgs[6]),
                            Integer.parseInt(commandArgs[7]),
                            Integer.parseInt(commandArgs[8]),
                            Integer.parseInt(commandArgs[9]));
                    break;
                case "check":
                    System.out.println(carManager.check(Integer.parseInt(commandArgs[1])));
                    break;
                case "open":
                    carManager.open(Integer.parseInt(commandArgs[1]),
                            commandArgs[2],
                            Integer.parseInt(commandArgs[3]),
                            commandArgs[4],
                            Integer.parseInt(commandArgs[5]),
                            commandArgs);
                    break;
                case "participate":
                    carManager.participate(Integer.parseInt(commandArgs[1]),
                            Integer.parseInt(commandArgs[2]));
                    break;
                case "start":
                    System.out.println(carManager.start(Integer.parseInt(commandArgs[1])));
                    break;
                case "park":
                    carManager.park(Integer.parseInt(commandArgs[1]));
                    break;
                case "unpark":
                    carManager.unpark(Integer.parseInt(commandArgs[1]));
                    break;
                case "tune":
                    carManager.tune(Integer.parseInt(commandArgs[1]),
                            commandArgs[2]);
                    break;
            }
        }
    }
}