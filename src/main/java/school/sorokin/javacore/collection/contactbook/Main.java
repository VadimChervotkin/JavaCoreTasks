package school.sorokin.javacore.collection.contactbook;

import school.sorokin.javacore.exception.books.Catalog;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean choice = true;
        Book book = new Book();
        while (choice) {
            System.out.println("Введите команду из списка:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Удалить контакт");
            System.out.println("3. Посмотреть все контакты");
            System.out.println("4. Найти контакт");
            System.out.println("5. Посмотреть контакты по группе");
            System.out.println("0. Выход");
            int input = 0;
            try {
                int command = scanner.nextInt();
                scanner.nextLine();
                if (command > 5 || command < 0) {
                    System.out.println("Такой команды нет. Введите число от 0 до 5.");
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
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Введите Телефон: ");
                    String phone = scanner.nextLine().trim();
                    System.out.print("Введите Email: ");
                    String email = scanner.nextLine().trim();
                    System.out.print("Введите группу: ");
                    String group = scanner.nextLine().trim();
                    Contact contact = new Contact(name, phone, email, group);
                    book.addContact(contact);
                    break;
                case 2:
                    System.out.print("Введите имя: ");
                    String nameRemove = scanner.nextLine().trim();
                    book.removeContactByName(nameRemove);
                    break;
                case 3:
                    try {
                        book.showAllContacts();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Введите имя: ");
                    String nameSearch = scanner.nextLine().trim();
                    book.searchContact(nameSearch);
                    break;
                case 5:
                    System.out.print("Введите название группы: ");
                    String nameSearchByGroup = scanner.nextLine().trim();
                    book.searchContactsByGroup(nameSearchByGroup);
                    break;
                case 0:
                    choice = false;
            }
        }
    }
}
