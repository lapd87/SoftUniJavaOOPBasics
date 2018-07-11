package _03Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 20.6.2018 г.
 * Time: 12:47 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            String[] studentArgs = bufferedReader.readLine()
                    .split("\\s+");

            String studentFirstName = studentArgs[0];
            String studentLastName = studentArgs[1];
            String studentFacultyNumber = studentArgs[2];

            String[] workerArgs = bufferedReader.readLine()
                    .split("\\s+");

            String workerFirstName = workerArgs[0];
            String workerLastName = workerArgs[1];
            double workerWeekSalary = Double
                    .parseDouble(workerArgs[2]);
            double workerWorkHoursPerDay = Double
                    .parseDouble(workerArgs[3]);


            Student student = new Student(studentFirstName,
                    studentLastName, studentFacultyNumber);

            Worker worker = new Worker(workerFirstName,
                    workerLastName, workerWeekSalary,
                    workerWorkHoursPerDay);

            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}