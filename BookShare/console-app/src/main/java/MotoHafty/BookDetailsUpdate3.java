package MotoHafty;

public class BookDetailsUpdate3 extends AddNewBook1 {

    public Integer askUserForBookId() {
        Library library = new Library();
        Integer pickedIdInt = -1;
        Boolean ispicked = false;
        while (!ispicked) {
            System.out.println("_________________________________");
            System.out.println("Wprowadź Id ksiązki, której dane chcesz zaktualizować: ");
            String pickedId = scanner.nextLine();
            if (pickedId.matches("\\d+")) {
                pickedIdInt = Integer.parseInt(pickedId);
                for (Integer i : library.getAllBooks().keySet()) {
                    if (library.getAllBooks().containsKey(pickedIdInt)) {
                        System.out.println("Wybrano książkę do edycji: ");
                        System.out.println("#########################################");
                        System.out.println("ID: " + pickedIdInt);
                        System.out.println("Tytuł: " + library.getAllBooks().get(pickedIdInt).getTitle());
                        System.out.println("Główny autor: " + library.getAllBooks().get(pickedIdInt).getMainAuthorName());
                        ispicked = true;
                        return pickedIdInt;
                    } else {
                        System.out.println("!!!Ksiązka o podanym ID nie widnieje w biblioteczce");
                    }
                    break;
                }
            } else {
                System.out.println("!!!Wprowadzono błędną wartość");
            }
        }
        return pickedIdInt;
    }

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

    public Book updateBookDetails() {
        boolean isUpdated = false;
        while (!isUpdated) {
            System.out.println("Skrócone dane wszystkich książek znajdujacych się w Biblioteczce");
            printShortInfoAboutAllBooksFromMap(getAllBooks());
            Integer id = askUserForBookId();
            askforBookDetailsUpdate(id);
            System.out.println("Zaktualizowano książkę:");
            printOneBookDetails(id);
            isUpdated = true;
        }
        return null;
    }

}

