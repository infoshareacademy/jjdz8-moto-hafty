package MotoHafty.repository;

import MotoHafty.domain.Book;

import javax.ejb.Local;
import java.util.Map;

@Local
public interface BookRepository {

    void addNewBooK(Book book);
    void updateBook(Integer id, Book editedBook);
    Map<Integer, Book> readBooks();
    void addBookToShelf(Integer id);
    void removeBookFromShelf(Integer id);
    Map<Integer, Book> readShelfBooks(Integer userId);
    void clearShelf(Integer userId);
}
