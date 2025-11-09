package ua.opnu.Task6;

public class GenericThreeTuple<T, V, S> {

    public final GenericTwoTuple<T, V> twoTuple;
    public final S third;

    public GenericThreeTuple(T first, V second, S third) {
        this.twoTuple = new GenericTwoTuple<>(first, second);
        this.third = third;
    }

    public T getFirst() {
        return twoTuple.first;
    }

    public V getSecond() {
        return twoTuple.second;
    }

    @Override
    public String toString() {
        return "(" + twoTuple.first + ", " + twoTuple.second + ", " + third + ')';
    }
}
