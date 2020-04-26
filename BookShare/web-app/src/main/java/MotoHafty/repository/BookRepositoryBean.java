package MotoHafty.repository;

import MotoHafty.domain.Book;
import MotoHafty.storage.BookDb;

import javax.inject.Inject;
import java.util.Collections;

public class BookRepositoryBean implements BookRepository {

    @Inject
    private BookDb bookDb;

    @Override
    public void addNewBooK(Book book) {
        bookDb.getAllBooks().put(Collections.max(bookDb.getAllBooks().keySet()) + 1, book);
    }

    public void updateBook(Integer id, Book editedBook) {
        bookDb.getAllBooks().put(id, editedBook);
    }

}
