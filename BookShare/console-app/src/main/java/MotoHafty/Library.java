package MotoHafty;

import java.util.LinkedHashMap;
import java.util.Map;

public class Library {

   //narazie zrobiłem że jako id przypisuje się hashcode nowo utworzonej książki.
    //książka dodaje do mapy się w momencie utworzenia (metoda addNewBook)

    private Integer id;
    private static Map<Integer, Book> books = new LinkedHashMap<>();

    public Integer getId() {
        return id;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }
}
