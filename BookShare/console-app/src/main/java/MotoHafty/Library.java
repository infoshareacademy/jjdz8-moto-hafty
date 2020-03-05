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

    public void printAllBooks (){
        System.out.println("_________________________________");
        System.out.println("W Biblioteczce znajdują się następujące ksiązki:");
        for (Map.Entry<Integer,Book> entry : books.entrySet()) {
            System.out.println("#########################################");
            System.out.println("ID: " + entry.getKey());
            System.out.println("Tytuł: " + entry.getValue().getTitle());
            System.out.println("Główny autor: " + entry.getValue().getAuthors().get(0));
            System.out.println("Wszyscy autorzy: " + entry.getValue().getAuthors().toString());
            System.out.println("Kategoria: " + entry.getValue().getCategory());
            System.out.println("ISBN: " + entry.getValue().getIsbn());
            System.out.println("Data dodania: " + entry.getValue().getInputDate());
            System.out.println("Status książki: " + (entry.getValue().getRead() ? "Przeczytana": "Nieprzeczytana"));
            System.out.println("Opis: " + entry.getValue().getDescription());
        }
    }
}
