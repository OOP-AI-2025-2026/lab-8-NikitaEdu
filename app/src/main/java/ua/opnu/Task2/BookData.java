package ua.opnu.Task2;

import java.util.Objects;

public class BookData implements Comparable<BookData> {

    private final String title;
    private final String author;
    private final int reviews;
    private final double total;

    public BookData(String title, String author, int reviews, double total) {
        if (reviews < 0 || total < 0) {
            throw new IllegalArgumentException("Кількість оглядів та сума не можуть бути негативними");
        }
        this.title = Objects.requireNonNull(title, "Назва не може бути null");
        this.author = Objects.requireNonNull(author, "Автор не може бути null");
        this.reviews = reviews;
        this.total = total;
    }

    private double getRating() {
        if (reviews == 0) {
            return 0.0;
        }
        return total / reviews;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public int compareTo(BookData other) {
        double thisRating = this.getRating();
        double otherRating = other.getRating();

        int ratingCompare = Double.compare(otherRating, thisRating);

        if (ratingCompare != 0) {
            return ratingCompare;
        }

        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return String.format("Book[title='%s', rating=%.2f (%d reviews)]",
                this.title, this.getRating(), this.reviews);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookData bookData = (BookData) o;
        return title.equals(bookData.title) &&
                author.equals(bookData.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
