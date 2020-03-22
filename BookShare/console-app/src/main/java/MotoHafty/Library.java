package MotoHafty;

import java.util.*;

public class Library extends Book {

    private static Map<Integer, Book> allBooks = new LinkedHashMap<>();
    public Integer id = 0;

    public Map<Integer, Book> getAllBooks() {
        return allBooks;
    }

    public Library() {
    }

    public void printAllBooks() {
        System.out.println("_________________________________");
        System.out.println("W Biblioteczce znajdują się następujące ksiązki:");
        for (Map.Entry<Integer, Book> entry : getAllBooks().entrySet()) {
            System.out.println("###############################################################################");
            System.out.println("ID: " + entry.getKey());
            System.out.println("Tytuł: " + entry.getValue().getTitle());
            System.out.println("Główny autor: " + entry.getValue().getMainAuthorName());
            System.out.println("Wszyscy autorzy: " + Arrays.toString(entry.getValue().getAuthors().toArray()));
            System.out.println("Kategoria: " + entry.getValue().getCategory());
            System.out.println("ISBN: " + entry.getValue().getIsbn());
            System.out.println("Data dodania: " + entry.getValue().getInputDate());
            System.out.println("Status książki: " + (entry.getValue().getRead() ? "Przeczytana" : "Nieprzeczytana"));
            System.out.println("Opis: " + entry.getValue().getDescription());
        }
    }

    public void printShortInfoAboutAllBooksFromMap(Map<Integer, Book> libraryOrShelf) {
        System.out.println("_________________________________");
        for (Map.Entry<Integer, Book> entry : libraryOrShelf.entrySet()) {
            System.out.println("#########################################");
            System.out.println("ID: " + entry.getKey());
            System.out.println("Tytuł: " + entry.getValue().getTitle());
            System.out.println("Główny autor: " + entry.getValue().getMainAuthorName());
        }
    }

    public void printOneBookShortDetails(Integer id) {
        System.out.println("ID: " + id);
        System.out.println("Tytuł: " + getAllBooks().get(id).getTitle());
        System.out.println("Główny autor: " + getAllBooks().get(id).getMainAuthorName());
    }

    public void printOneBookDetails(Integer id){
        printOneBookShortDetails(id);
        System.out.println("Wszyscy autorzy: " + Arrays.toString(getAllBooks().get(id).getAuthors().toArray()));
        System.out.println("Kategoria: " + getAllBooks().get(id).getCategory());
        System.out.println("ISBN: " + getAllBooks().get(id).getIsbn());
        System.out.println("Data dodania: " + getAllBooks().get(id).getInputDate());
        System.out.println("Status książki: " + (getAllBooks().get(id).getRead() ? "Przeczytana" : "Nieprzeczytana"));
        System.out.println("Opis: " + getAllBooks().get(id).getDescription());
    }

    public Boolean checkIsBookInLibrary(Integer id) {
        return getAllBooks().containsKey((id));
    }

    public Integer checkIsNumber(String inputId) {
        if (inputId.matches("[0-9]+")) {
            return Integer.parseInt(inputId);
        } else {
            return -1;
        }
    }

    public String askForBookId() {
        System.out.println("_________________________________");
        System.out.println("Wprowadź ID Książki: ");
        return scanner.nextLine();
    }

    public void addTestBooksToLibrary() {

        List<String> authorsTestList = new ArrayList<>();
        authorsTestList.add("test autor 1");
        authorsTestList.add("test autor 2");
        authorsTestList.add("test autor 3");

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Wrócę, gdy będziesz spała", "Patrycja Dołowy", new ArrayList<>(), "Literatura Piękna | Biografia/Pamiętniki", "978-83-8049-830-3", AddNewBook1.generateDateInStringNow(), true, "Książka o dzieciach z holokaustu"));
        bookList.add(new Book("Polskie badania nad myślą pedagogiczną w latach 1900-1939", "Sławomir Sztobryn", authorsTestList, "Literatura Użytkowa | Naukowe/Specjalistyczne", "83-89574-24-1", AddNewBook1.generateDateInStringNow(), false, "Nudna ksiązka xD"));
        bookList.add(new Book("Współczesny behawioryzm - analiza zachowania od A do Z", "Przemysław Bąbel", new ArrayList<>(), "Literatura Użytkowa | Naukowe/Specjalistyczne", "9788374892674", AddNewBook1.generateDateInStringNow(), true, "gfhg"));
        bookList.add(new Book("Jekyll i Hyde", "John Rowan", new ArrayList<>(), "Literatura Użytkowa | Popularnonaukowe", "ISBN: 9788389574961", AddNewBook1.generateDateInStringNow(), true, "a"));
        bookList.add(new Book("People as care catalysts", "Richard Normann", new ArrayList<>(), "Literatura Użytkowa | Popularnonaukowe", "isbn0-470-01778-3", AddNewBook1.generateDateInStringNow(), true, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi tempus elit et dapibus dictum. Cras consequat volutpat erat, eget rhoncus enim. Cras faucibus finibus lectus id pretium. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut eget neque ac tellus fermentum vulputate eu et augue. Pellentesque iaculis velit a ornare gravida. Nunc tincidunt imperdiet nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse potenti. Cras massa magna, egestas vel feugiat eget, ultricies at ex. "));
        bookList.add(new Book("Viral - jak zarażać ideami i tworzyć wirusowe treści tytuł tej ksiązki już się zakończył, ale chcę mieć długo do testów", "Piotr Bucki", getAuthors(), "Literatura Użytkowa | Popularnonaukowe", "9788301204631", AddNewBook1.generateDateInStringNow(), true, "Super Ksiązka polecam serdecznie "));
        bookList.add(new Book("Drucker o marketingu", "William A. Cohem", authorsTestList, "Literatura użytkowa | Podręczniki", "978-83-63566-24-1", AddNewBook1.generateDateInStringNow(), true, "książka o czymś"));
        bookList.add(new Book("Wywieranie wpływu na ludzi", "Robert B.", new ArrayList<>(), "Literatura użytkowa | bleble", "978-83-7489-250-6", AddNewBook1.generateDateInStringNow(), true, "książka o czymś"));
        bookList.add(new Book("Błyskawiczne wywieranie wpływu", "Michael V. Pantalon", new ArrayList<>(), "Literatura użytkowa | Podręczniki", "9788374893466", AddNewBook1.generateDateInStringNow(), false, "książka o czymś"));
        for (Book book : bookList) {
            if (book.getAuthors().isEmpty())
            book.getAuthors().add(book.getMainAuthorName());
            getAllBooks().put(id,book);
            id++;
        }
    }
}
