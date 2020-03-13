package MotoHafty;

import java.util.LinkedHashMap;
import java.util.Map;

public class Shelf extends Library {

    private Boolean isOnShelf;
    private String shelfAddDate;

    private static Map<Integer, Book> shelf = new LinkedHashMap<>();

    public static Map<Integer, Book> getShelf() {
        return shelf;
    }

    public static void setShelf(Map<Integer, Book> shelf) {
        Shelf.shelf = shelf;
    }

    private void printAllBooksFromShelf(){
        //TODO
    }

    public void printShelfMenuOptions(){

        System.out.println("1: Podgląd książek znajdujących się na półce");
        System.out.println("2: Umieszczenie jednej książki na półce");
        System.out.println("3: Usunięcie książki z półki");
        System.out.println("4: Usunięcie wszystkich książek z półki");
        System.out.println("5: Powrót do menu głównego");
    }

    public void shelfMenu() {
        Boolean isFinished = false;
        String number = "";
        while (!isFinished) {
            System.out.println("_________________________________");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Wybierz odpowiednią opcję: ");
            printShelfMenuOptions();
            number = scanner.nextLine();
            switch (number) {
                case "1": {

                }
            }


        }
    }

}
