package MotoHafty;

public class BookDetailsUpdate3 extends AddNewBook1 {

    public void askforBookDetailsUpdate(Integer id) {
        getAllBooks().get(id).setTitle(askForTitle());
        getAllBooks().get(id).setMainAuthorName(askForName());
        getAllBooks().get(id).setAuthors(getAuthors());
        getAllBooks().get(id).setCategory(askForCategory());
        getAllBooks().get(id).setIsbn(askForISBN());
        getAllBooks().get(id).setInputDate(generateDateInStringNow());
        getAllBooks().get(id).setRead(askIsRead());
        getAllBooks().get(id).setDescription(askForDescription());
    }

    public void updateBookDetails() {
        boolean isUpdated = false;
        while (!isUpdated) {
            System.out.println("Skrócone dane wszystkich książek znajdujacych się w Biblioteczce:");
            printShortInfoAboutAllBooksFromMap(getAllBooks());
            Integer id = checkIsNumber(askForBookId());
            if (checkIsBookInLibrary(id)) {
                printOneBookDetails(id);
                askforBookDetailsUpdate(id);
                System.out.println("_________________________________");
                System.out.println("Zaktualizowane dane książki: ");
                printOneBookDetails(id);
                System.out.println("Zmiany zostały zapisane");
                System.out.println("_________________________________");
                isUpdated = true;
            } else System.out.println("!!!Ksiązka o podanym ID nie widnieje w biblioteczce");
        }
    }
}

