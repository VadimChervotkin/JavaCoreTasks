package school.sorokin.javacore.OOP.finalApp;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean choice = true;
        Library library = new Library();
        while (choice) {
            System.out.println("Выберите опцию из списка и нажмите '0' для выхода: ");
            System.out.println("1: Добавить новую публикацию");
            System.out.println("2: Вывести список всех публикаций");
            System.out.println("3: Поиск публикации по автору");
            System.out.println("4: Удалить публикацию по названию");
            System.out.println("5: Вывести общее количество публикаций");
            String input = sc.nextLine().trim();
            boolean isNumber = true;
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) {
                    isNumber = false;
                    break;
                }
            }
            if (!isNumber) {
                System.out.println("Некорректный ввод. Введите число от 0 до 5.");
                continue;
            }
            int command = Integer.parseInt(input);
            if (command > 5 || command < 0) {
                System.out.println("Такой команды нет. Введите число от 0 до 5.");
                continue;
            }
            switch (command) {
                case 0:
                    choice = false;
                    break;
                case 1:
                    System.out.print("Выберите тип публикации: 1 – Book, 2 – Magazine, 3 – Newspaper: ");
                    String type = sc.nextLine().trim();
                    System.out.print("Введите название: ");
                    String title = sc.nextLine();
                    System.out.print("Введите автора: ");
                    String author = sc.nextLine();
                    System.out.print("Введите год: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    switch (type) {
                        case "1":
                            System.out.print("Введите ISBN: ");
                            String ISBN = sc.nextLine().trim();
                            Book book = new Book(title, author, year, ISBN);
                            library.addPublication(book);

                            break;
                        case "2":
                            System.out.print("Введите номер выпуска: ");
                            int issueNumber = sc.nextInt();
                            sc.nextLine();
                            Magazine magazine = new Magazine(title, author, year, issueNumber);
                            library.addPublication(magazine);

                            break;
                        case "3":
                            System.out.print("Введите день публикации: ");
                            String publicationDay = sc.nextLine().trim();
                            Newspaper newspaper = new Newspaper(title, author, year, publicationDay);
                            library.addPublication(newspaper);
                            break;
                        default:
                            System.out.println("Некорректный выбор");
                            break;
                    }
                    break;
                case 2:
                    library.listPublications();
                    break;
                case 3:
                    System.out.print("Введите автора: ");
                    String authorSearch = sc.nextLine().trim();
                    library.searchByAuthor(authorSearch);
                    break;
                case 4:
                    System.out.print("Введите название: ");
                    String titleSearch = sc.nextLine().trim();
                    library.removePublication(titleSearch);
                    break;
                case 5:
                    System.out.println("Общее число публикаций: " + Publication.getPublicationCount());
            }
        }
    }
}
