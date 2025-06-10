package school.sorokin.javacore.exception.books;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean choice = true;
        Catalog catalog = new Catalog();
        while (choice) {
            System.out.println("Введите команду из списка:");
            System.out.println("1. Вывести каталог");
            System.out.println("2. Добавить объект");
            System.out.println("3. Выдать объект");
            System.out.println("4. Вернуть объект");
            System.out.println("5. Выйти из приложения");
            int input = 0;
            try {
                int command = scanner.nextInt();
                scanner.nextLine();
                if (command > 5 || command < 1) {
                    System.out.println("Такой команды нет. Введите число от 1 до 5.");
                    continue;
                }
                input = command;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Повторите ввод");
                continue;
            }
            switch (input) {
                case 1:
                    try {
                        catalog.showBooks();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Введите название: ");
                    String title = scanner.nextLine().trim();
                    System.out.print("Введите автора: ");
                    String author = scanner.nextLine().trim();
                    System.out.print("Введите количество: ");
                    int availableCopies = scanner.nextInt();
                    Book book = new Book(title, author, availableCopies);
                    catalog.addBook(book);
                    break;

                case 3:
                    System.out.print("Введите название: ");
                    String titleFound = scanner.nextLine().trim();
                    catalog.getBook(titleFound);
                    break;

                case 4:
                    System.out.print("Введите название: ");
                    String titleSearch = scanner.nextLine().trim();
                    catalog.returnBook(titleSearch);
                    break;

                case 5:
                    choice = false;
            }

        }
    }
}
