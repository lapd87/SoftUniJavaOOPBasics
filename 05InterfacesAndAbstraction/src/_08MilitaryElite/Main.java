package _08MilitaryElite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.7.2018 г.
 * Time: 11:27 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        List<Private> privateSoldiers = new ArrayList<>();

        String input;
        while (true) {
            if ("End".equals(input = bufferedReader.readLine())) {
                break;
            }

            try {
                String[] soldierData = input.split("\\s+");
                String soldierType = soldierData[0];
                int soldierId = Integer.parseInt(soldierData[1]);
                String soldierFirstName = soldierData[2];
                String soldierLastName = soldierData[3];

                Soldier soldier = null;

                if ("Spy".equals(soldierType)) {
                    String codeNumber = soldierData[4];
                    soldier = setSpy(soldierId,
                            soldierFirstName,
                            soldierLastName,
                            codeNumber);
                } else {
                    double privateSalary = Double
                            .parseDouble(soldierData[4]);

                    switch (soldierType) {
                        case "Private":
                            soldier = setPrivate(soldierId,
                                    soldierFirstName,
                                    soldierLastName,
                                    privateSalary);
                            break;
                        case "LeutenantGeneral":
                            soldier = setLeutenantGeneral(privateSoldiers,
                                    soldierData,
                                    soldierId,
                                    soldierFirstName,
                                    soldierLastName,
                                    privateSalary);
                            break;
                        case "Engineer":
                            soldier = setEngineer(soldierData,
                                    soldierId,
                                    soldierFirstName,
                                    soldierLastName,
                                    privateSalary);
                            break;
                        case "Commando":
                            soldier = setCommando(soldierData,
                                    soldierId,
                                    soldierFirstName,
                                    soldierLastName,
                                    privateSalary);
                            break;
                    }

                    if (soldier != null) {
                        privateSoldiers.add((Private) soldier);
                    }
                }

                if (soldier != null) {
                    System.out.println(soldier);
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private static Soldier setCommando(String[] soldierData, int soldierId, String soldierFirstName, String
            soldierLastName, double privateSalary) {
        Soldier soldier;

        Corp corp = setCorp(soldierData);

        if (corp == null) {
            return null;
        }

        Set<Mission> missions = new LinkedHashSet<>();

        for (int i = 6; i < soldierData.length; i += 2) {
            String missionName = soldierData[i];

            State missionState = null;
            try {
                missionState = new State(soldierData[i + 1]);
            } catch (IllegalArgumentException iae) {
                continue;
            }

            Mission mission = new Mission(missionName,
                    missionState);

            missions.add(mission);
        }

        soldier = new Commando(soldierId, soldierFirstName,
                soldierLastName, privateSalary, corp, missions);
        return soldier;
    }

    private static Corp setCorp(String[] soldierData) {
        Corp corp = null;

        try {
            corp = new Corp(soldierData[5]);
        } catch (IllegalArgumentException iae) {
            return null;
        }

        return corp;
    }

    private static Soldier setEngineer(String[] soldierData, int soldierId, String soldierFirstName, String
            soldierLastName, double privateSalary) {
        Soldier soldier;

        Corp corp = setCorp(soldierData);

        if (corp == null) {
            return null;
        }

        Set<Repair> repairs = new LinkedHashSet<>();

        for (int i = 6; i < soldierData.length; i += 2) {
            String partName = soldierData[i];
            int workedHours = Integer.parseInt(soldierData[i + 1]);

            Repair repair = new Repair(partName, workedHours);

            repairs.add(repair);
        }

        soldier = new Engineer(soldierId, soldierFirstName,
                soldierLastName, privateSalary, corp, repairs);
        return soldier;
    }

    private static Soldier setLeutenantGeneral(List<Private> privateSoldiers, String[] soldierData, int soldierId,
                                               String
                                                       soldierFirstName, String soldierLastName, double privateSalary) {
        Soldier soldier;
        Set<Private> privates = new LinkedHashSet<>();

        for (int i = 5; i < soldierData.length; i++) {
            int privateId = Integer.parseInt(soldierData[i]);

            privateSoldiers.stream()
                    .filter(s -> s.getId() == privateId)
                    .findFirst()
                    .ifPresent(privates::add);
        }

        soldier = new LeutenantGeneral(soldierId, soldierFirstName,
                soldierLastName, privateSalary, privates);
        return soldier;
    }

    private static Soldier setPrivate(int soldierId, String soldierFirstName, String soldierLastName, double
            privateSalary) {
        Soldier soldier;
        soldier = new Private(soldierId, soldierFirstName,
                soldierLastName, privateSalary);
        return soldier;
    }

    private static Soldier setSpy(int soldierId, String soldierFirstName, String soldierLastName, String codeNumber) {
        Soldier soldier;
        soldier = new Spy(soldierId, soldierFirstName,
                soldierLastName, codeNumber);
        return soldier;
    }
}