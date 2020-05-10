package MotoHafty.repository;

import MotoHafty.domain.Book;
import MotoHafty.storage.BookDb;
import MotoHafty.storage.BookFromJsonDb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collections;
import java.util.Map;

@Stateless
public class BookRepositoryBean implements BookRepository {

    @Inject
    private BookFromJsonDb bookFromJsonDb;

    @Override
    public void addNewBooK(Book book) {
        bookFromJsonDb.addBook(book);
    }

    @Override
    public void updateBook(Integer id, Book editedBook) {
        bookFromJsonDb.getAllBooks().put(id, editedBook);
    }

    @Override
    public Map<Integer, Book> readBooks() {
        return bookFromJsonDb.getAllBooks();
    }
}
