package MotoHafty;

import static MotoHafty.Shelf.getShelf;

public class BooksOnShelf4 extends Library {


    public String askForBookId() {
        System.out.println("_________________________________");
        System.out.println("Wprowadź ID Książki: ");
        return scanner.nextLine();
    }

    public Integer checkIsNumber(String inputId) {
        if (inputId.matches("[0-9]+")) {
            return Integer.parseInt(inputId);
        } else {
            return -1;
        }
    }

    public Boolean checkIsBookInLibrary(Integer id) {
        return getAllBooks().containsKey((id));
    }

    public void putBookOnShelf() {
        printShortInfoAboutAllBooksFromMap(getAllBooks());
        String inputID = askForBookId();
        Integer inputIdInteger = checkIsNumber(inputID);
        if (checkIsBookInLibrary(inputIdInteger)) {
            getShelf().put(inputIdInteger, getAllBooks().get(inputIdInteger));
            System.out.println("Do biblioteczki wprowadzono książkę: ");
            printOneBookShortDetails(inputIdInteger);
        } else {
            System.out.println("!!!Książka o podanym ID nie znajduje się w biblioteczce");
        }
    }

    public Boolean checkIsBookOnShelf(Integer id) {
        return getShelf().containsKey(id);
    }

    public void removeBookFromShelf() {
        if (!checkIsShelfEmpty()) {
            printShortInfoAboutAllBooksFromMap(getShelf());
            String inputId = askForBookId();
            Integer inputInInteger = checkIsNumber(inputId);
            if (checkIsBookOnShelf(inputInInteger)) {
                getShelf().remove(inputInInteger);
                System.out.println("_________________________________");
                System.out.println("Z półki usunieto książkę: ");
                printOneBookShortDetails(inputInInteger);
            } else {
                System.out.println("!!!Książka o podanym ID nie znajduje się na półce");
            }
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
        if (!checkIsShelfEmpty()) {
            System.out.println("_________________________________");
            System.out.println("Ilość książek na półce: " + getShelf().size() + " książek");
            System.out.println("Aby zatwierdzić usunięcie wszystkich książek z półki, naciśnij + ");
            System.out.println("Aby zrezygnować, naciśnij inny dowolny klawisz");
            String decision = scanner.nextLine();
            if (decision.equalsIgnoreCase("+")){
                getShelf().clear();
                System.out.println("Wszystkie książki zostały usunięte z półki.");
            }
        }
    }
}
