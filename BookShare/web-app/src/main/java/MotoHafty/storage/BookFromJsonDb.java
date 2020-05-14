package MotoHafty.storage;

import MotoHafty.domain.Book;
import MotoHafty.service.JsonService;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Stateful
public class BookFromJsonDb implements BookDb {

    @Inject
    private JsonService jsonService;
    private static final String BOOKS_JSON = "Books.json";

    @Override
    public Map<Integer, Book> getAllBooks() {
        String path = Objects.requireNonNull(getClass().getClassLoader().getResource(BOOKS_JSON)).getPath();
        return jsonService.importUserJsonFileBooks(path);
    }

    @Override
    public void addBook(Book book) {
    }

    //FIXME
    private String generateDateInStringNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(new Date());
    }
}
