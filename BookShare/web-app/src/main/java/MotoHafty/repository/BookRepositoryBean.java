package MotoHafty.repository;

import MotoHafty.domain.Book;
import MotoHafty.storage.BookDb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Map;

@Stateless
public class BookRepositoryBean implements BookRepository {

    @Inject
    private BookDb bookDb;

    @Override
    public void addNewBooK(Book book) {
        bookDb.addBook(book);
    }

    @Override
    public void updateBook(Integer id, Book editedBook) {
        bookDb.getAllBooks()
              .put(id, editedBook);
    }

    @Override
    public Map<Integer, Book> readBooks() {
        return bookDb.getAllBooks();
    }
}
