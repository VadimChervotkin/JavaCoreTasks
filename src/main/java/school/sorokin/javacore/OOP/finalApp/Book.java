package school.sorokin.javacore.OOP.finalApp;

import java.util.Objects;

public class Book extends  Publication implements Printable{
    String ISBN;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }

    @Override
    public String getType() {
        return "Книга";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ISBN);
    }

    @Override
    public String toString() {
        return "Book " + super.toString() + " ISBN: " + ISBN;
    }

    @Override
    public void printDetails() {
        System.out.println("Book " + super.toString() + " ISBN: " + ISBN);
    }
}
