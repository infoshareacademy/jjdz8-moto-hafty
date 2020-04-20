package MotoHafty;

import static MotoHafty.Shelf.getShelf;

public class BooksOnShelf4 extends Library {

    public void putBookOnShelf() {
        clearScreen();
        System.out.println("Dodawanie książki na półkę do wypożyczenia:");
        printShortInfoAboutAllBooksFromMap(getAllBooks());
        String inputID = askForBookId();
        Integer inputIdInteger = checkIsNumber(inputID);
        if (checkIsBookInLibrary(inputIdInteger)) {
            getShelf().put(inputIdInteger, getAllBooks().get(inputIdInteger));
            printLineOfChars('-', true);
            System.out.println("Do biblioteczki wprowadzono książkę: ");
            printLineOfChars('-', true);
            printOneBookShortDetails(inputIdInteger);
            printLineOfChars('-', true);
        } else {
            System.out.println("!!!Książka o podanym ID nie znajduje się w biblioteczce");
        }
    }

    public Boolean checkIsBookOnShelf(Integer id) {
        return getShelf().containsKey(id);
    }

    public void removeBookFromShelf() {
        clearScreen();
        System.out.println("Usuwanie książki z półki do wypożyczenia:");
        if (!checkIsShelfEmpty()) {
            printShortInfoAboutAllBooksFromMap(getShelf());
            String inputId = askForBookId();
            printLineOfChars('-', true);
            Integer inputInInteger = checkIsNumber(inputId);
            if (checkIsBookOnShelf(inputInInteger)) {
                getShelf().remove(inputInInteger);
                System.out.println("Z półki usunieto książkę: ");
                printLineOfChars('-', true);
                printOneBookShortDetails(inputInInteger);
            } else {
                System.out.println("!!!Książka o podanym ID nie znajduje się na półce");
            }
            printLineOfChars('-', true);
        }
    }

    public Boolean checkIsShelfEmpty() {
        if (getShelf().isEmpty()) {
            System.out.println("!!!Półka jest pusta");
            return true;
        } else
            return false;
    }

    public void clearShelf() {
        clearScreen();
        System.out.println("Usunięcie wszystkich książęk znajdujących się na półce do wypożyczenia");
        if (!checkIsShelfEmpty()) {
            printLineOfChars('-',true);
            System.out.println("Ilość książek na półce: " + getShelf().size());
            printShortInfoAboutAllBooksFromMap(getShelf());
            System.out.println("Aby zatwierdzić usunięcie wszystkich książek z półki, naciśnij + ");
            System.out.print("Aby zrezygnować, naciśnij inny dowolny klawisz: ");
            String decision = scanner.nextLine();
            printLineOfChars('-',true);
            if (decision.equalsIgnoreCase("+")) {
                getShelf().clear();
                System.out.println("Wszystkie książki zostały usunięte z półki.");
            } else System.out.println("Półka nie została wyczyszczona");
            printLineOfChars('-',true);
        }
    }
}
