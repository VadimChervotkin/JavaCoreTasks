package school.sorokin.javacore.basics;

import java.util.Scanner;

public class ContactAccountingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[100];
        String[] phoneNumbers = new String[100];
        int size = 0;
        boolean choice = true;

        while (choice) {
            System.out.println("Введите номер команды:\n1. Добавить контакт 2. Просмотреть контакты 3. Найти контакт  4. Удалить контакт 5. Выйти");
            String input = sc.nextLine();
            boolean isNumber = true;
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) {
                    isNumber = false;
                    break;
                }
            }
            if (!isNumber) {
                System.out.println("Некорректный ввод. Введите число от 1 до 5.");
                continue;
            }
            int command = Integer.parseInt(input);
            if (command > 5 || command < 1 ) {
                System.out.println("Такой команды нет. Введите число от 1 до 5.");
                continue;
            }
            switch (command) {
                case 1:
                    if (size < 100) {
                        System.out.print("Введите имя или 0, чтобы выйти в меню: ");
                        String name = sc.nextLine();
                        if (name.equals("0")) {
                            continue;
                        }
                        names[size] = name;
                        System.out.print("Введите номер телефона: ");
                        String number = sc.nextLine();
                        phoneNumbers[size] = number;
                        size++;
                    } else {
                        System.out.println("Список контактов полон");
                    }
                    break;
                case 2:
                    for (int i = 0; i <= size - 1; i++) {
                        System.out.println((i + 1) + "." + names[i] + " - " + phoneNumbers[i]);
                    }
                    break;
                case 3:
                    System.out.print("Введите имя контакта: ");
                    String nameSearch = sc.nextLine();
                    boolean searchAdd = false;
                    String phoneNumber = "";
                    for (int i = 0; i <= size - 1; i++) {
                        if (nameSearch.equals(names[i])) {
                            searchAdd = true;
                            phoneNumber = phoneNumbers[i];
                        }
                    }
                    if (searchAdd) {
                        System.out.println("Телефон " + nameSearch + ": " + phoneNumber);
                    } else {
                        System.out.println("Контакт с именем " + nameSearch + " не найден");
                    }
                    break;
                case 4:
                    System.out.print("Введите имя контакта: ");
                    String nameDelete = sc.nextLine();
                    boolean searchDelete = false;
                    for (int i = 0; i <= size - 1; i++) {
                        if (nameDelete.equals(names[i])) {
                            for (int j = i; j < size - 1; j++) {
                                names[j] = names[j + 1];
                                phoneNumbers[j] = phoneNumbers[j + 1];
                            }
                            size--;
                            searchDelete = true;
                        }
                    }
                    if (searchDelete) {
                        for (int i = 0; i <= size - 1; i++) {
                            System.out.println((i + 1) + "." + names[i] + " - " + phoneNumbers[i]);
                        }
                    } else {
                        System.out.println("Контакт с именем " + nameDelete + " не найден");
                    }
                    break;
                case 5:
                    choice = false;
            }
        }

    }
}
