package MotoHafty.storage;

import MotoHafty.domain.Book;
import MotoHafty.service.JsonService;
import MotoHafty.servlet.config.WebInfPathResolver;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Map;


@Stateless
public class BookFromJsonDb implements BookDb {

    private static final String BOOKS_FILE_NAME = "Books.json";

    @Inject
    private JsonService jsonService;

    @Inject
    private WebInfPathResolver webInfPathResolver;

    @Override
    public Map<Integer, Book> getAllBooks() {
        String booksJsonPath = webInfPathResolver.getFilePath(BOOKS_FILE_NAME);
        return jsonService.importBooksJsonFile(booksJsonPath);
    }

    @Override
    public void addBook(Book book) {
        getAllBooks().put(getAllBooks().keySet().size() +1, book);
        jsonService.exportBooksToJsonFile(getAllBooks());
    }
}
