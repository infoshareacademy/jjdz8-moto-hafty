package MotoHafty;

import java.util.LinkedHashMap;
import java.util.Map;

public class Shelf extends BooksOnShelf4 {

    private Boolean isOnShelf;
    private String shelfAddDate;

    public static Map<Integer, Book> shelf = new LinkedHashMap<>();

    public static Map<Integer, Book> getShelf() {
        return shelf;
    }

    public static void setShelf(Map<Integer, Book> shelf) {
        Shelf.shelf = shelf;
    }

    public void printShelfMenuOptions() {

        System.out.println("1: Podgląd książek znajdujących się na półce");
        System.out.println("2: Umieszczenie jednej książki na półce");
        System.out.println("3: Usunięcie książki z półki");
        System.out.println("4: Usunięcie wszystkich książek z półki");
        System.out.println("5: Powrót do menu głównego");
    }

    public void shelfMenu() {
        Boolean isFinishedShelf = false;
        String number = "";
        while (!isFinishedShelf) {
            System.out.println("_________________________________");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Wybierz odpowiednią opcję: ");
            printShelfMenuOptions();
            number = scanner.nextLine();
            switch (number) {
                case "1": {
                    System.out.println("Skrócone dane książek znajdujących się na półce:");
                    if (shelf.isEmpty()) {
                        System.out.println("!!!Półka jest pusta");
                    } else {
                        printShortInfoAboutAllBooksFromMap(shelf);
                        break;
                    }
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
                    System.out.println("!!!Wybrano nieodpowiednią opcję, spróbuj jeszcze raz");
                }
            }


        }
    }

}
