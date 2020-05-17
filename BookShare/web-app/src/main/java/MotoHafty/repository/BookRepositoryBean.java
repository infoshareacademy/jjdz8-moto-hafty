package MotoHafty.repository;

import MotoHafty.domain.Book;
import MotoHafty.storage.BookDb;
import MotoHafty.storage.BookFromJsonDb;
import MotoHafty.storage.BookInMemoryDb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.*;

@Stateless
public class BookRepositoryBean implements BookRepository {

    @EJB(beanName = "BookFromJsonDb")
    private BookDb bookFromJsonDb;

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
//        return new HashMap<Integer, Book>();

        }
    }

