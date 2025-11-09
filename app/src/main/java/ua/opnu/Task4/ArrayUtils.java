package ua.opnu.Task4;

import java.util.Arrays;
import java.util.function.Predicate;
import java.lang.reflect.Array;

public class ArrayUtils {

    @SuppressWarnings("unchecked")
    public <T> T[] filter(T[] input, Predicate<T> p) {

        Class<?> componentType = input.getClass().getComponentType();

        T[] result = (T[]) Array.newInstance(componentType, input.length);

        int counter = 0;
        for (T item : input) {
            if (p.test(item)) {
                result[counter] = item;
                counter++;
            }
        }
        return Arrays.copyOfRange(result, 0, counter);
    }
}