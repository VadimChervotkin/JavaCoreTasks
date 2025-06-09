package school.sorokin.javacore.exception.books;



public class Book {
    private final String title;
    private final String author;
    private int availableCopies;

    public Book(String title, String author, int availableCopies) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void borrow() throws NoAvailableCopiesException{
        if (availableCopies <= 0) {
            throw new NoAvailableCopiesException(availableCopies);
        }
        availableCopies--;
    }
    public void returnCopy() {
        availableCopies++;
    }

    @Override
    public String toString() {
        return "Название: " + title + " Автор " + author + " (" + availableCopies + " количество)";
    }
}
