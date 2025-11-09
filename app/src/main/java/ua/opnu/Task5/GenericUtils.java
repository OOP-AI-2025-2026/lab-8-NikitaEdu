package ua.opnu.Task5;

public class GenericUtils {

    public <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {

        if (array == null || element == null) {return false;}
        for (T item : array) {
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }
}
