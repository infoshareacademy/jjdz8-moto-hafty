package MotoHafty;

import java.util.LinkedHashMap;
import java.util.Map;

public class Library {

    //jeszcze tu podziubie, mapa ma przechowywać in narastające o 1 z każdą książką, i książkę jako wartość.
    // id właściwie tylko dla nas do testów na później, użytkownik nie widzi tej wartości

    private Integer id;
    private Map<Integer, Book> books = new LinkedHashMap<>();

    public Integer getId() {
        return id;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }
}
