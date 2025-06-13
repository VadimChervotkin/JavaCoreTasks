package school.sorokin.javacore.collection.contactbook;

import java.util.*;

public class Book {
    private final List<Contact> bookList = new ArrayList<>();
    private final Set<Contact> bookSet = new HashSet<>();
    private final Map<String, List<Contact>> bookMap = new HashMap<>();

    public void addContact(Contact contact) {
        if (bookSet.add(contact)) {
            bookList.add(contact);
            List<Contact> groupContacts = bookMap.getOrDefault(contact.getGroup(), new ArrayList<>());
            groupContacts.add(contact);
            bookMap.put(contact.getGroup(), groupContacts);
            System.out.println("Контакт добавлен");
        } else {
            System.out.println("Такой контакт уже существует!");
        }
    }

    public void removeContactByName(String name){
        Contact toRemove = null;
        for (Contact contact : bookList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                toRemove = contact;
                break;
            }
        }
        if (toRemove != null) {
            bookList.remove(toRemove);
            bookSet.remove(toRemove);
            List<Contact> groupContacts = bookMap.get(toRemove.getGroup());
            if (groupContacts != null) {
                groupContacts.remove(toRemove);
                if (groupContacts.isEmpty()) {
                    bookMap.remove(toRemove.getGroup());
                }
            }
            System.out.println("Контакт удален: " + toRemove);
        } else {
            System.out.println("Контакт " + name + " не найден");
        }
    }

    public void showAllContacts() {
        if (bookList.isEmpty()) {
            throw new IllegalStateException("Книга контактов пуста");
        }
        Iterator<Contact> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for(Contact contact : bookList) {
            if(contact.getName().equalsIgnoreCase(name)) {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Контакт не найден");
        }
    }

    public void searchContactsByGroup(String group) {
        if (bookMap.containsKey(group)) {
            List<Contact> contactsGroup = bookMap.get(group);
            Iterator<Contact> iterator = contactsGroup.iterator();
            System.out.println("Контакты в группе " + "'" + group + "'");
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } else {
            System.out.println("Группа " + group + " не найдена");
        }
    }
}
