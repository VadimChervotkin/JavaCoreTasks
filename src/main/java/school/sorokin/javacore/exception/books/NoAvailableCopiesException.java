package school.sorokin.javacore.exception.books;

public class NoAvailableCopiesException extends Exception{
    public NoAvailableCopiesException(int availableCopies) {
        super("Нет доступных экземпляров");
    }
}
