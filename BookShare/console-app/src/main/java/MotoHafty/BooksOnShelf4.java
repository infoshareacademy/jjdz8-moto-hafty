package MotoHafty;

public class BooksOnShelf4 extends Library {


    public String askForBookId() {
        System.out.println("_________________________________");
        System.out.println("Wprowadź ID Książki, którą chcesz umieścić na półce: ");
        return scanner.nextLine();
    }

    public Integer checkIsNumber(String inputId) {
        if (inputId.matches("[0-9]+")) {
            return Integer.parseInt(inputId);
        } else {
            return -1;
        }
    }

    public Boolean checkIsBookInLibrary(Integer convertedToIntegerID) {
        return getAllBooks().containsKey((convertedToIntegerID));
    }

    public void putBookOnShelf() {
        printShortInfoAboutAllBooksFromMap(getAllBooks());
        String inputID = askForBookId();
        Integer inputIdInteger = checkIsNumber(inputID);
        if (checkIsBookInLibrary(inputIdInteger)){
            Shelf.getShelf().put(inputIdInteger,getAllBooks().get(inputIdInteger));
            System.out.println("Do biblioteczki wprowadzono książkę: ");
            printOneBookShortDetails(inputIdInteger);
        }else {
            System.out.println("!!!Książka o podanym ID nie znajduje się w biblioteczce");
        }
    }


    public void removeBookFromShelf() {
        //TODO
    }

    public void clearShelf() {
        //TODO
        //pamietaj o zapytaniu czy na pewno wszystkie
    }


}
