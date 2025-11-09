package ua.opnu;

import ua.opnu.Task1.MyOptional;
import ua.opnu.Task3.Printer;
import ua.opnu.Task4.ArrayUtils;
import ua.opnu.Task5.GenericUtils;
import ua.opnu.Task6.GenericThreeTuple;
import ua.opnu.Task6.GenericTwoTuple;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // 1. Порожнє значення (наприклад, у користувача немає по-батькові)
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName); // MyOptional[empty]
        System.out.println("isPresent: " + middleName.isPresent()); // false
        System.out.println("orElse: " + middleName.orElse("немає")); // "немає"

        // 2. Заповнене значення (наприклад, логін користувача)
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username); // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent()); // true
        System.out.println("get(): " + username.get()); // "admin"
        System.out.println("orElse: " + username.orElse("guest")); // "admin"

        // 3. Перевіримо, що get() на порожньому об'єкті кидає помилку
        try {
            String test = middleName.get(); // має кинути IllegalStateException
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Перевіримо, що конструктор не приймає null
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }

        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        //Task4
        ArrayUtils filterUtil = new ArrayUtils();

        // --- Тест 1: Фільтрація масиву Integer ---
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Predicate<Integer> isEven = (n) -> n % 2 == 0;
        Integer[] evenNumbers = filterUtil.filter(numbers, isEven);
        System.out.println("Парні числа: " + Arrays.toString(evenNumbers));


        // --- Тест 2: Фільтрація масиву String ---
        String[] words = {"Яблуко", "Кіт", "Стіл", "Програмування", "Дім", "Java"};
        Predicate<String> isLongerThan4 = (s) -> s.length() > 4;
        String[] longWords = filterUtil.filter(words, isLongerThan4);
        System.out.println("Довгі слова: " + Arrays.toString(longWords));

        //Task 5
        GenericUtils utils = new GenericUtils();

        // 1. Тест з String (String implements Comparable<String>)
        String[] stringArrayTwo = {"apple", "banana", "cherry"};

        boolean hasBanana = utils.contains(stringArrayTwo, "banana");
        boolean hasGrape = utils.contains(stringArrayTwo, "grape");

        System.out.println("Масив: " + Arrays.toString(stringArrayTwo));
        System.out.println("Містить 'banana': " + hasBanana);
        System.out.println("Містить 'grape': " + hasGrape);

        // 2. Тест з Integer (Integer implements Comparable<Integer>)
        Integer[] intArrayTwo = {1, 2, 3, 4};

        boolean has20 = utils.contains(intArrayTwo, 2);
        boolean has50 = utils.contains(intArrayTwo, 5);

        System.out.println("\nМасив: " + Arrays.toString(intArray));
        System.out.println("Містить 2: " + has20);
        System.out.println("Містить 5: " + has50);

        //Task 6

        System.out.println("--- 1. Демонстрація GenericTwoTuple ---");

        GenericTwoTuple<String, java.time.LocalDate> userTuple = getUserActivity(42);

        String usernameTwo = userTuple.first;
        java.time.LocalDate lastLogin = userTuple.second;

        System.out.println("Користувач: " + usernameTwo);
        System.out.println("Останній вхід: " + lastLogin);
        System.out.println(" toString: " + userTuple);

        System.out.println("\n--- 2. Демонстрація GenericThreeTuple ---");

        GenericThreeTuple<String, Double, Boolean> projectResult =
                calculateProjectScore("Alpha-01");

        System.out.println("Проект: " + projectResult.getFirst());
        System.out.println("Бал: " + String.format("%.2f", projectResult.getSecond()));
        System.out.println("Статус затвердження: " + projectResult.third);
        System.out.println(" toString: " + projectResult);
    }

    //Task 6
    public static GenericTwoTuple<String, LocalDate> getUserActivity(int userId) {
        if (userId == 42) {
            return new GenericTwoTuple<>("Alex", java.time.LocalDate.now());
        }
        return new GenericTwoTuple<>("Guest", java.time.LocalDate.MIN);
    }

    public static GenericThreeTuple<String, Double, Boolean> calculateProjectScore(String projectName) {
        double score = Math.random() * 100;
        boolean isApproved = score > 80;

        return new GenericThreeTuple<>(projectName, score, isApproved);
    }
}
