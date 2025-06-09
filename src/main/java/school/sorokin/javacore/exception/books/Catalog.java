package school.sorokin.javacore.exception.books;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Catalog {
    private final List<Book> catalog = new ArrayList<>();

    public void addBook(Book book) {
        this.catalog.add(book);
    }

    public void showBooks() {
        if (catalog.isEmpty()) {
            throw new IllegalStateException("Каталог пуст");
        }
        for (Book book : this.catalog) {
            System.out.println(book);
        }
    }

    public void getBook(String title) {
        try {
            Book book = findBookByTitle(title);
            book.borrow();
            System.out.println("Вы взяли книгу: " + book);
        } catch (NoSuchElementException e) {
            System.out.println("Такой публикации нет в каталоге");
        } catch (NoAvailableCopiesException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(String title) {

        try {
            Book book = findBookByTitle(title);
            book.returnCopy();
            System.out.println("Книга возвращена: " + book);
        } catch (NoSuchElementException e) {
            System.out.println("Такой публикации нет в каталоге");
        }
    }

    private Book findBookByTitle(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        throw new NoSuchElementException("Книга не найдена: " + title);
    }
}
