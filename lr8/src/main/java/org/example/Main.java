package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 Задание");
        List<String> list = new ArrayList<>(Arrays.asList("ббб", "ааа", "аааа", "ааа", "аааа", "бб"));

        System.out.println("Повторяющиеся слова в алфатном порядке и в порядке увеличения длины: " + list.stream()
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(groupingBy(
                        entry -> entry.getKey().length(), // Группировка по длине слова
                        TreeMap::new,
                        mapping(Map.Entry::getKey, toList())
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // Сортировка по длине
                .map(longListEntry -> longListEntry.getValue().stream().sorted().collect(joining(", ")))
                .collect(Collectors.joining(", ")));


        System.out.println("-------------");
        System.out.println("2 Задание");
        System.out.println(" ");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Bekbolat", "1", 2, 2.75),
                new Student("Bahtyar", "2", 1, 3.5),
                new Student("Shahboz", "3", 4, 3),
                new Student("Kazbek", "4", 4, 4),
                new Student("Bober", "5", 4, 5)

        ));
        int N = 3; // Количество искомых сотрудников

        System.out.println(students.stream()
                .sorted(Comparator.comparing(Student::getPoint))
                .limit(N)
                .sorted(Comparator.comparing(Student::getPoint).reversed())
                .map(Student::getName)
                .collect(Collectors.joining(", ", N + " самых плохих плохиша: ", ";")));
    }
}