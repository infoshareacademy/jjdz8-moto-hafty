package MotoHafty;

import java.time.LocalDateTime;
import java.util.*;

public class AddNewBook {

    Scanner scanner = new Scanner(System.in);
    List<String> authors = new LinkedList<>();

//
//    public Book createNewBook(){
//        System.out.println("########################################################");
//        System.out.println();
//        Book book = new Book();
//    }

    public String askForTitle() {
        boolean isTitleOK = false;
        String title = "";
        while (!isTitleOK) {
            try {
                System.out.println("_________________________________");
                System.out.println("Wprowadź tytuł książki: ");
                title = scanner.nextLine();
                if (title.equalsIgnoreCase("") || title.trim().equalsIgnoreCase("")) {
                    System.out.println("Nazwa nie może być pusta");
                } else {
                    System.out.println("Wprowadzony tytuł to: " + title);
                    isTitleOK = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono błędne dane, spróbuj jeszcze raz:");
            }
        }
        return title;
    }

    public String askForName() {
        boolean isNameOK = false;
        String name = "";
        while (!isNameOK) {
            try {
                boolean allAuthorsAdded = false;
                System.out.println("_________________________________");
                System.out.println("Wprowadź imię i nazwisko autora: ");
                name = scanner.nextLine();
                if (name.equalsIgnoreCase("") || name.trim().equalsIgnoreCase("")) {
                    System.out.println("Imię i nazwisko autora nie moogą być puste");
                } else {
                    System.out.println("Wprowadzone dane autora to: " + name);
                    System.out.println("Wpisz \"+\", aby dodać kolejnego autora. Jeśli nie chcesz - naciśnij enter");
                    authors.add(name);
                    while (!allAuthorsAdded) {
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("+")) {
                            break;
                        } else {
                            isNameOK = true;
                            allAuthorsAdded = true;
                        }
                        System.out.println("Głównym autorem jest: " + authors.get(0));
                        System.out.println("Wszyscy autorzy: " + Arrays.toString(authors.toArray()));
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono błędne dane, spróbuj jeszcze raz");
            }
        }
        return name;
    }
}
