package MotoHafty.repository;

import MotoHafty.domain.Book;

public interface BookRepository {

    void addNewBooK(Book book);
    void updateBook(Integer id, Book editedBook);
}
