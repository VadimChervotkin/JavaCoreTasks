package school.sorokin.javacore.OOP.finalApp;

import java.util.Objects;

public abstract class Publication implements Printable {
    String title;
    String author;
    int year;

    private static int publicationCount = 0;

    public static void addPublicationCount() {
        publicationCount++;
    }

    public static void removePublicationCount() {
        publicationCount--;
    }

    public static int getPublicationCount() {
        return publicationCount;
    }

    public Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return year == that.year && Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Публикация: " + "Название: " + title + " Автор: " + author + " year: " + year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



    public abstract String getType();
}

