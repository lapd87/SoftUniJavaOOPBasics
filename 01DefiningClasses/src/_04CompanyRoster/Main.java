package _04CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 14.6.2018 г.
 * Time: 19:16 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] input = bufferedReader.readLine()
                    .split("\\s+");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];

            Employee employee = new Employee(name, salary,
                    position, department);

            switch (input.length) {
                case 5:
                    String emailOrAge = input[4];
                    try {
                        int age = Integer.parseInt(emailOrAge);
                        employee.setAge(age);
                    } catch (NumberFormatException nfe) {
                        String email = emailOrAge;
                        employee.setEmail(email);
                    }
                    break;
                case 6:
                    int age = Integer.parseInt(input[5]);
                    String email = input[4];

                    employee.setEmail(email);
                    employee.setAge(age);
                    break;
            }

            employees.add(employee);
        }

        employees.stream()
                .collect(groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted((kv1, kv2) -> {
                    double averageSalary1 = kv1.getValue()
                            .stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();

                    double averageSalary2 = kv2.getValue()
                            .stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();

                    return Double.compare(averageSalary2, averageSalary1);
                })
                .limit(1)
                .forEach(kv -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Highest Average Salary: ")
                            .append(kv.getKey())
                            .append(System.lineSeparator());

                    kv.getValue()
                            .stream()
                            .sorted(Comparator
                                    .comparing(Employee::getSalary)
                                    .reversed())
                            .forEach(stringBuilder::append);

                    System.out.println(stringBuilder);
                });
    }
}