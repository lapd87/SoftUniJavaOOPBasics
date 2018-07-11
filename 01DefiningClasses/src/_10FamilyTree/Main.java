package _10FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 15.6.2018 г.
 * Time: 10:56 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String parentNameChildName = "^[\\w\\s]+ - [\\w\\s]+$";
        String parentNameChildBDate = "^[\\w\\s]+ - [\\w\\/]+$";
        String parentBDateChildName = "^[\\w\\/]+ - [\\w\\s]+$";
        String parentBDateChildBDate = "^[\\w\\/]+ - [\\w\\/]+$";
        String personNameBDate = "^[\\w\\s]+ [\\w\\/]+$";

        String searchedPersonNameOrBDate = bufferedReader.readLine();

        List<Person> relatives = new ArrayList<>();

        List<String> relations = new ArrayList<>();

        String input = null;
        while (!"End".equals(input = bufferedReader.readLine())) {

            if (input.matches(personNameBDate)) {
                String[] inputArgs = input.split("\\s+");

                String name = inputArgs[0] + " " + inputArgs[1];
                String birthday = inputArgs[2];

                Person person = new Person(name, birthday);

                relatives.add(person);
            } else {
                relations.add(input);
            }
        }

        Person searchedPerson = new Person();

        if (searchedPersonNameOrBDate.contains("/")) {
            String birthday = searchedPersonNameOrBDate;
            searchedPerson.setBirthday(birthday);

            relatives.stream()
                    .filter(r -> birthday.equals(r.getBirthday()))
                    .forEach(r -> searchedPerson.setName(r.getName()));
        } else {
            String name = searchedPersonNameOrBDate;
            searchedPerson.setName(name);

            relatives.stream()
                    .filter(r -> name.equals(r.getName()))
                    .forEach(r -> searchedPerson.setBirthday(r.getBirthday()));
        }

        for (String relation : relations) {

            String[] relationArgs = relation.split(" - ");
            String parentData = relationArgs[0];
            String childData = relationArgs[1];

            if (!parentData.equals(searchedPerson.getName())
                    && !parentData.equals(searchedPerson.getBirthday())
                    && !childData.equals(searchedPerson.getName())
                    && !childData.equals(searchedPerson.getBirthday())) {
                continue;
            }


            if (relation.matches(parentNameChildName)) {
                String parentName = parentData;
                String childName = childData;

                if (parentName.equals(searchedPerson.getName())) {
                    relatives.stream()
                            .filter(r -> childName.equals(r.getName()))
                            .forEach(r -> searchedPerson.getChildren().add(r));
                } else {
                    relatives.stream()
                            .filter(r -> parentName.equals(r.getName()))
                            .forEach(r -> searchedPerson.getParents().add(r));
                }
            } else if (relation.matches(parentNameChildBDate)) {
                String parentName = parentData;
                String childBDate = childData;

                if (parentName.equals(searchedPerson.getName())) {
                    relatives.stream()
                            .filter(r -> childBDate.equals(r.getBirthday()))
                            .forEach(r -> searchedPerson.getChildren().add(r));
                } else {
                    relatives.stream()
                            .filter(r -> parentName.equals(r.getName()))
                            .forEach(r -> searchedPerson.getParents().add(r));
                }
            } else if (relation.matches(parentBDateChildName)) {
                String parentBDate = parentData;
                String childName = childData;

                if (parentBDate.equals(searchedPerson.getBirthday())) {
                    relatives.stream()
                            .filter(r -> childName.equals(r.getName()))
                            .forEach(r -> searchedPerson.getChildren().add(r));
                } else {
                    relatives.stream()
                            .filter(r -> parentBDate.equals(r.getBirthday()))
                            .forEach(r -> searchedPerson.getParents().add(r));
                }
            } else if (relation.matches(parentBDateChildBDate)) {
                String parentBDate = parentData;
                String childBDate = childData;

                if (parentBDate.equals(searchedPerson.getBirthday())) {
                    relatives.stream()
                            .filter(r -> childBDate.equals(r.getBirthday()))
                            .forEach(r -> searchedPerson.getChildren().add(r));
                } else {
                    relatives.stream()
                            .filter(r -> parentBDate.equals(r.getBirthday()))
                            .forEach(r -> searchedPerson.getParents().add(r));
                }
            }
        }

        System.out.println(searchedPerson);
    }
}