package school.sorokin.javacore.OOP.finalApp;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Publication> publications = new ArrayList<>();



    public void addPublication(Publication pub){
        publications.add(pub);
        Publication.addPublicationCount();
    }

    public void listPublications() {
        for (Publication publication : publications) {
            publication.printDetails();
        }
    }

    public void searchByAuthor(String author) {
        boolean found = false;

        for (Publication publication : publications) {
            if (publication.author.equals(author)) {
                System.out.println(publication);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Автор не найден");
        }
    }

    public void removePublication(String title) {
        Publication found = null;

        for (Publication publication : publications) {
            if (publication.title.equals(title)) {
                found = publication;
                break;
            }
        }

        if (found != null) {
            publications.remove(found);
            Publication.removePublicationCount();
            System.out.println(found + " удалена из списка публикаций");
        } else {
            System.out.println("Публикация не найдена");
        }
    }
}
