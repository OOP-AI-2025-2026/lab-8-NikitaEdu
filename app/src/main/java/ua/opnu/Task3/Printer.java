package ua.opnu.Task3;

public class Printer {

    public <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.println(element);
        }
    }
}
