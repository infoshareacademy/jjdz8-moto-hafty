package MotoHafty.repository;

import MotoHafty.domain.Book;
import MotoHafty.storage.BookDb;
import MotoHafty.storage.UserDb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Stateless
public class BookRepositoryBean implements BookRepository {

    @EJB(beanName = "BookFromJsonDb")
    private BookDb bookFromJsonDb;

    @EJB
    private UserDb userDb;

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

    @Override
    public void addBookToShelf(Integer bookId) {
        userDb.getAllUsers().get(1).getUserShelf().add(bookId);
    }

    @Override
    public void removeBookFromShelf(Integer bookId) {
        userDb.getAllUsers().get(1).getUserShelf().remove(bookId);
    }

    @Override
    public Map<Integer, Book> readShelfBooks(Integer userId) {
        Map<Integer, Book> booksFromUserShelf = new HashMap<>();
        for (Integer bookId : userDb.getAllUsers().get(userId).getUserShelf()){
            if (readBooks().containsKey(bookId)){
                booksFromUserShelf.put(bookId, readBooks().get(bookId));
            }
        }
        return  booksFromUserShelf;
    }

    @Override
    public void clearShelf(Integer userId) {
        userDb.getAllUsers().get(userId).getUserShelf().clear();
    }
}

