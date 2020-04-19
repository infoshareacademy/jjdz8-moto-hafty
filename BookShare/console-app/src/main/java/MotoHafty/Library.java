package MotoHafty;

import java.util.*;
import java.util.stream.Collectors;

public class Library extends Book {

    private static Map<Integer, Book> allBooks = new LinkedHashMap<>();
    public Integer id = 0;
    public static int CONSOLEWIDTH = 166;

    public Map<Integer, Book> getAllBooks() {
        return allBooks;
    }

    public Library() {
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
        Integer MaxFieldIdLenght = 6;
        Integer MaxFieldTitleLenght = 60;
        Integer MaxFieldMainAuthorLenght = 30;
        Integer MaxLineLenght = MaxFieldIdLenght + MaxFieldTitleLenght + MaxFieldMainAuthorLenght;
        printLineOfChars('-', true);
        System.out.print("|");
        printFieldLineForTable("ID", MaxFieldIdLenght);
        printFieldLineForTable("Tytuł", MaxFieldTitleLenght);
        printFieldLineForTable("Główny autor", MaxFieldMainAuthorLenght);
        System.out.println();
        printLineOfChars('-', false);
        if (libraryOrShelf.size() == 0) {
            printFieldLineForTable("  Nie znalazłem książek spełniających wymagania", MaxLineLenght);
            return;
        }
        for (Map.Entry<Integer, Book> entry : libraryOrShelf.entrySet()) {
            System.out.print("\n|");
            printFieldLineForTable(entry.getKey().toString(), MaxFieldIdLenght);
            printFieldLineForTable(entry.getValue().getTitle(), MaxFieldTitleLenght);
            printFieldLineForTable(entry.getValue().getMainAuthorName(), MaxFieldMainAuthorLenght);
        }
        System.out.println();
        printLineOfChars('-', true);
    }

    public void printOneBookShortDetails(Integer id) {
        System.out.println("ID:              | " + id);
        System.out.println("Tytuł:           | " + getAllBooks().get(id).getTitle());
        System.out.println("Główny autor:    | " + getAllBooks().get(id).getMainAuthorName());
    }

    public void printOneBookDetails(Integer id) {
        printOneBookShortDetails(id);
        System.out.println("Wszyscy autorzy: | " + Arrays.toString(getAllBooks().get(id).getAuthors().toArray()));
        System.out.println("Kategoria:       | " + getAllBooks().get(id).getCategory());
        System.out.println("ISBN:            | " + getAllBooks().get(id).getIsbn());
        System.out.println("Data dodania:    | " + getAllBooks().get(id).getInputDate());
        System.out.println("Status książki:  | " + (getAllBooks().get(id).getRead() ? "Przeczytana" : "Nieprzeczytana"));
        System.out.println("Opis:\n" + getAllBooks().get(id).getDescription());
        printLineOfChars('-', true);
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
        System.out.print("Wprowadź ID Książki: ");
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
            getAllBooks().put(id, book);
            id++;
        }
    }

    public void printFieldLineForTable(String text, Integer maxLenght) {
        if (text.length() > maxLenght) {
            System.out.print(" " + text.substring(0, (maxLenght - 3)) + "...");
        } else {
            System.out.print(" " + text);
            for (int i = 0; i < (maxLenght - text.length()); i++) {
                System.out.print(" ");
            }
        }
        System.out.print("|");
    }

    public void printTableOfBooksByListOfId(List<Integer> idList) {
//        Definition of width of table columns
        Integer MaxFieldIdLenght = 6;
        Integer MaxFieldTitleLenght = 41;
        Integer MaxFieldMainAuthorLenght = 20;
        Integer MaxFieldCategoryLenght = 20;
        Integer MaxFieldIsbnLenght = 14;
        Integer MaxFieldInputDateLenght = 12;
        Integer MaxFieldBookStatusLenght = 11;
        Integer MaxFieldDescriptionLenght = 25;
        Integer MaxLineLenght = MaxFieldIdLenght + MaxFieldTitleLenght + MaxFieldMainAuthorLenght
                + MaxFieldCategoryLenght + MaxFieldIsbnLenght + MaxFieldInputDateLenght + MaxFieldBookStatusLenght
                + MaxFieldDescriptionLenght;
//        Head line printing
        printLineOfChars('-', true);
        System.out.print("|");
        printFieldLineForTable("ID", MaxFieldIdLenght);
        printFieldLineForTable("Tytuł", MaxFieldTitleLenght);
        printFieldLineForTable("Główny autor", MaxFieldMainAuthorLenght);
        printFieldLineForTable("Kategoria", MaxFieldCategoryLenght);
        printFieldLineForTable("Isbn", MaxFieldIsbnLenght);
        printFieldLineForTable("Data dodania", MaxFieldInputDateLenght);
        printFieldLineForTable("Przeczytana", MaxFieldBookStatusLenght);
        printFieldLineForTable("Opis", MaxFieldDescriptionLenght);
        System.out.println();
        printLineOfChars('-', false);
        if (idList.size() == 0) {
            printFieldLineForTable("  Nie znalazłem książek spełniających wymagania", MaxLineLenght);
            return;
        }
        for (Integer entry : idList) {
            Book entryBook = getAllBooks().get(entry);
            System.out.print("\n|");
            printFieldLineForTable(entry.toString(), MaxFieldIdLenght);
            printFieldLineForTable(entryBook.getTitle(), MaxFieldTitleLenght);
            printFieldLineForTable(entryBook.getMainAuthorName(), MaxFieldMainAuthorLenght);
            printFieldLineForTable(entryBook.getCategory(), MaxFieldCategoryLenght);
            printFieldLineForTable(entryBook.getIsbn().replaceAll("[^0-9]","").trim(), MaxFieldIsbnLenght);
            printFieldLineForTable(entryBook.getInputDate(), MaxFieldInputDateLenght);
            printFieldLineForTable(entryBook.getRead() ? "TAK" : "NIE", MaxFieldBookStatusLenght);
            printFieldLineForTable(entryBook.getDescription(), MaxFieldDescriptionLenght);
        }
        printLineOfChars('-', true);
    }

    public void printLineOfChars(char character, boolean putNewLineOnEnd) {
        for (int i = 0; i < (CONSOLEWIDTH - 1); i++) {
            System.out.print(character);
        }
        if (putNewLineOnEnd) {
            System.out.println(character);
        }
    }
}
