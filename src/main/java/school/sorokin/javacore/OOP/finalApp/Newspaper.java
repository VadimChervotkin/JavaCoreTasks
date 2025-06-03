package school.sorokin.javacore.OOP.finalApp;

import java.util.Objects;

public class Newspaper extends  Publication implements Printable{

    String publicationDay;

    public String getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
    }

    @Override
    public String getType() {
        return "Газета";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Newspaper newspaper = (Newspaper) o;
        return Objects.equals(publicationDay, newspaper.publicationDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationDay);
    }

    @Override
    public String toString() {
        return "Book " + super.toString() + " publicationDay: " + publicationDay;
    }

    @Override
    public void printDetails() {
        System.out.println("Book " + super.toString() + " publicationDay: " + publicationDay);
    }
}
