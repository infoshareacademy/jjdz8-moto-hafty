package MotoHafty.storage;

import MotoHafty.domain.Book;
import MotoHafty.service.JsonService;

import javax.ejb.Stateful;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.*;

@Default
@Stateful
public class BookFromJsonDb implements BookDb {

    @Inject
    private JsonService jsonService;
    private Integer id = 1;
    private Map<Integer, Book> books = new LinkedHashMap<>();

    @Override
    public Map<Integer, Book> getAllBooks() {
        return jsonService.importUserJsonFileBooks(Objects.requireNonNull(getClass().getClassLoader().getResource("Books.json")).getPath());
//        return new HashMap<>();
    }

    @Override
    public void addBook(Book book) { }

    //FIXME
    private String generateDateInStringNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(new Date());
    }



}
