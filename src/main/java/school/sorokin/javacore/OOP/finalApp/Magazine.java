package school.sorokin.javacore.OOP.finalApp;

import java.util.Objects;

public class Magazine extends  Publication implements Printable{
    int issueNumber;

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getType() {
        return "Журнал";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return issueNumber == magazine.issueNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), issueNumber);
    }

    @Override
    public String toString() {
        return "Book " + super.toString() + " issueNumber: " + issueNumber;
    }

    @Override
    public void printDetails() {
        System.out.println("Book " + super.toString() + " issueNumber: " + issueNumber);
    }
}
