package ua.opnu.Task1;

public class MyOptional<T> {

    private final T value;
    private final boolean present;

    public MyOptional() {
        this.value = null;
        this.present = false;
    }

    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = value;
        this.present = true;
    }

    public boolean isPresent() {
        return this.present;
    }

    public boolean isEmpty() {
        // Просто інверсія isPresent()
        return !this.present;
    }

    public T get() {
        if (isEmpty()) {
            throw new IllegalStateException("Не можна викликати get() для порожнього MyOptional");
        }
        return this.value;
    }

    public T orElse(T defaultValue) {return this.present ? this.value : defaultValue;}


    @Override
    public String toString() {
        if (this.present) {
            return "MyOptional[value=" + this.value + "]";
        } else {
            return "MyOptional[empty]";
        }
    }
}
