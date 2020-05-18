package MotoHafty.repository;

import MotoHafty.domain.Book;
import MotoHafty.storage.BookDb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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

        }
    }

