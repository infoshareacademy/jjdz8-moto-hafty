package MotoHafty;

import java.util.LinkedHashMap;
import java.util.Map;

public class Shelf extends BooksOnShelf4 {

    private static Map<Integer, Book> shelf = new LinkedHashMap<>();

    public Shelf() {
    }

    public static Map<Integer, Book> getShelf() {
        return shelf;
    }

    public void printShelfMenuOptions() {

        System.out.println("1: Podgląd książek znajdujących się na półce");
        System.out.println("2: Umieszczenie jednej książki na półce");
        System.out.println("3: Usunięcie książki z półki");
        System.out.println("4: Usunięcie wszystkich książek z półki");
        System.out.println("5: Powrót do menu głównego");
    }

    public void printShelfBooks() {
        clearScreen();
        System.out.println("Skrócone dane książek znajdujących się na półce:");
        if (getShelf().isEmpty()) {
            printLineOfChars('-', true);
            System.out.println("!!!Półka jest pusta");
            printLineOfChars('-', true);
        } else {
            printShortInfoAboutAllBooksFromMap(getShelf());
        }
    }

    public void shelfMenu() {
        Boolean isFinishedShelf = false;
        String number = "";
        while (!isFinishedShelf) {
            System.out.println("Wybierz odpowiednią opcję: ");
            printShelfMenuOptions();
            number = scanner.nextLine();
            switch (number) {
                case "1": {
                    printShelfBooks();
                    continue;
                }
                case "2": {
                    putBookOnShelf();
                    continue;
                }
                case "3": {
                    removeBookFromShelf();
                    continue;
                }
                case "4": {
                    clearShelf();
                    continue;
                }
                case "5": {
                    isFinishedShelf = true;
                    break;
                }
                default: {
                    System.out.println("!!!Wybrano nieodpowiednią opcję, spróbuj jeszcze raz:");
                }
            }
        }
    }
}