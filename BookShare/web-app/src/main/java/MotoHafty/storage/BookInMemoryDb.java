package MotoHafty.storage;

import MotoHafty.domain.Book;
import MotoHafty.domain.Category;
import MotoHafty.service.UtilsService;

import javax.ejb.Stateful;
import java.text.SimpleDateFormat;
import java.util.*;

import static MotoHafty.service.UtilsService.generateDateInStringNow;

@Stateful
public class BookInMemoryDb implements BookDb {

    private Integer id = 1;
    private Map<Integer, Book> books = new LinkedHashMap<>();

    public BookInMemoryDb() {
        importBooksFromJson();
    }

    @Override
    public Map<Integer, Book> getAllBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
    }

    //FIXME zaimplementować zasysacz z jsonów
    private void importBooksFromJson(){
        List<String> authorsTestList = new ArrayList<>();
        authorsTestList.add("test autor 1");
        authorsTestList.add("test autor 2");
        authorsTestList.add("test autor 3");

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Wrócę, gdy będziesz spała", "Patrycja Dołowy", new ArrayList<>(), Category.BIOGRAFIE, "978-83-8049-830-3", generateDateInStringNow(), true, "Książka o dzieciach z holokaustu"));
        bookList.add(new Book("Polskie badania nad myślą pedagogiczną w latach 1900-1939", "Sławomir Sztobryn", authorsTestList, Category.EDUKACJA, "83-89574-24-1", generateDateInStringNow(), false, "Nudna ksiązka xD"));
        bookList.add(new Book("Współczesny behawioryzm - analiza zachowania od A do Z", "Przemysław Bąbel", new ArrayList<>(), Category.PODRĘCZNIKI_AKADEMICKIE, "9788374892674", generateDateInStringNow(), true, "gfhg"));
        bookList.add(new Book("Jekyll i Hyde", "John Rowan", new ArrayList<>(), Category.EDUKACJA, "ISBN: 9788389574961", generateDateInStringNow(), true, "a"));
        bookList.add(new Book("People as care catalysts", "Richard Normann", new ArrayList<>(), Category.NAUKI_SPOŁECZNE_I_HUMANISTYCZNE, "isbn0-470-01778-3",generateDateInStringNow(), true, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi tempus elit et dapibus dictum. Cras consequat volutpat erat, eget rhoncus enim. Cras faucibus finibus lectus id pretium. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut eget neque ac tellus fermentum vulputate eu et augue. Pellentesque iaculis velit a ornare gravida. Nunc tincidunt imperdiet nisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse potenti. Cras massa magna, egestas vel feugiat eget, ultricies at ex. "));
        bookList.add(new Book("Viral - jak zarażać ideami i tworzyć wirusowe treści tytuł tej ksiązki już się zakończył, ale chcę mieć długo do testów", "Piotr Bucki", authorsTestList, Category.NAUKI_SPOŁECZNE_I_HUMANISTYCZNE, "9788301204631", generateDateInStringNow(), true, "Super Ksiązka polecam serdecznie "));
        bookList.add(new Book("Drucker o marketingu", "William A. Cohem", authorsTestList, Category.PODRĘCZNIKI_AKADEMICKIE, "978-83-63566-24-1", generateDateInStringNow(), true, "książka o czymś"));
        bookList.add(new Book("Wywieranie wpływu na ludzi", "Robert B.", new ArrayList<>(), Category.PORADNIKI, "978-83-7489-250-6", generateDateInStringNow(), true, "książka o czymś"));
        bookList.add(new Book("Błyskawiczne wywieranie wpływu", "Michael V. Pantalon", new ArrayList<>(), Category.EDUKACJA, "9788374893466", generateDateInStringNow(), false, "książka o czymś"));
        for (Book book : bookList) {
            if (book.getAuthors().isEmpty())
                book.getAuthors().add(book.getMainAuthorName());
            getAllBooks().put(id, book);
            id++;
        }
    }



}
