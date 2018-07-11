package _01ItsInTheBlood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.7.2018 г.
 * Time: 20:28 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        HealthManager healthManager = new HealthManager();

        String input;
        while (true) {
            if ("BEER IS COMING".equals(input = bufferedReader.readLine())) {
                break;
            }

            String[] commandArgs = input.split("\\s+");

            String command = commandArgs[0];

            String result = null;
            switch (command) {
                case "checkCondition":
                    result = healthManager.checkCondition(commandArgs[1]);
                    break;
                case "createOrganism":
                    result = healthManager.createOrganism(commandArgs[1]);
                    break;
                case "addCluster":
                    result = healthManager.addCluster(commandArgs[1], commandArgs[2],
                            Integer.parseInt(commandArgs[3]), Integer.parseInt(commandArgs[4]));
                    break;
                case "addCell":
                    result = healthManager.addCell(commandArgs[1], commandArgs[2], commandArgs[3],
                            commandArgs[4], Integer.parseInt(commandArgs[5]), Integer.parseInt(commandArgs[6]),
                            Integer.parseInt(commandArgs[7]), Integer.parseInt(commandArgs[8]));
                    break;
                case "activateCluster":
                    result = healthManager.activateCluster(commandArgs[1]);
                    break;
            }

            if (result != null) {
                System.out.println(result);
            }
        }
    }
}