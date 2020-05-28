package MotoHafty.storage;

import MotoHafty.domain.Book;
import MotoHafty.service.JsonService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.text.SimpleDateFormat;
import java.util.*;


@Stateless
public class BookFromJsonDb implements BookDb {

    @EJB
    private JsonService jsonService;
    private Integer id = 1;
    private Map<Integer, Book> books = new LinkedHashMap<>();

    @Override
    public Map<Integer, Book> getAllBooks() {
        books = jsonService.importUserJsonFileBooks(Objects.requireNonNull(getClass().getClassLoader().getResource("Books.json")).getPath());
        id = books.size();
        return books;
    }

    @Override
    public void addBook(Book book) {
    }


}
