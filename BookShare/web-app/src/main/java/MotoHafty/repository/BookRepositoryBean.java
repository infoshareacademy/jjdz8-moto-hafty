package MotoHafty.repository;

import MotoHafty.domain.Book;
import MotoHafty.storage.BookDb;
import MotoHafty.storage.UserDb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.*;
import java.util.stream.Collectors;

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
        bookFromJsonDb.updateBook(id, editedBook);
    }

    @Override
    public void deleteBook(Integer id) {
        bookFromJsonDb.deleteBook(id);
    }

    @Override
    public Map<Integer, Book> findBook(String anyToFind, String titleToFind, String authorToFind, String categoryToFind, String isbnToFind, String descriptionToFind) {
        return readBooks().entrySet().stream()
                .filter(e -> (e.getValue().getAuthorsNamesInList().toString().toLowerCase().contains(anyToFind)
                        || e.getValue().getTitle().toLowerCase().contains(anyToFind)
                        || e.getValue().getIsbn().toLowerCase().replaceAll("[^0-9]","").contains(anyToFind)
                        || e.getValue().getDescription().toLowerCase().contains(anyToFind))
                        && e.getValue().getTitle().toLowerCase().contains(titleToFind)
                        && e.getValue().getAuthorsNamesInList().toString().toLowerCase().contains(authorToFind)
                        && e.getValue().getCategory().toLowerCase().contains(categoryToFind)
                        && e.getValue().getIsbn().toLowerCase().replaceAll("[^0-9]", "").contains(isbnToFind)
                        && e.getValue().getDescription().toLowerCase().contains(descriptionToFind))
                .map(Map.Entry::getKey)
                .collect(Collectors.toMap((e) -> (e), (e) -> (readBooks().get(e))));
    }

    @Override
    public Map<Integer, Book> readBooks() {
        return bookFromJsonDb.getAllBooks();}

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

