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

    @Override
    public Map<Integer, Book> getAllBooks() {
        return jsonService.importUserJsonFileBooks(Objects.requireNonNull(getClass().getClassLoader().getResource("Books.json")).getPath());
    }

    @Override
    public void addBook(Book book) { }
}
