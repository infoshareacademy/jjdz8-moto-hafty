package MotoHafty.repository;

import MotoHafty.domain.Book;

import java.util.Map;

public interface BookRepository {

    void addNewBooK(Book book);
    void updateBook(Integer id, Book editedBook);
    Map<Integer, Book> readBooks();
}
