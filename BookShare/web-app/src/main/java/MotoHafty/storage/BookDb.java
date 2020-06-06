package MotoHafty.storage;

import MotoHafty.domain.Book;

import javax.ejb.Local;
import java.util.Map;

@Local
public interface BookDb {

    Map<Integer, Book> getAllBooks();

    void addBook(Book book);

    void updateBook(Integer id, Book book);

    void deleteBook(Integer id);
}
