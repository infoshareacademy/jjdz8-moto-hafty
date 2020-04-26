package MotoHafty.storage;

import MotoHafty.domain.Book;

import java.util.Map;

public interface BookDb {

    Map<Integer, Book> getAllBooks();

}
