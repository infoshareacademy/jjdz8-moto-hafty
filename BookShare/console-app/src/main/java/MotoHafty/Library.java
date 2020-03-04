package MotoHafty;

import java.util.LinkedHashMap;
import java.util.Map;

public class Library {

    //jeszcze tu podziubie

    private Integer id;
    private Map<Integer, Book> books = new LinkedHashMap<>();

    public Integer getId() {
        return id;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }
}
