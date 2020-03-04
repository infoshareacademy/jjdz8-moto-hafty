package MotoHafty;

import java.time.LocalDateTime;
import java.util.List;

public class Book {

    private String title;
    private String name;
    private List<String> authors;
    private String category;
    private String isbn;
    private LocalDateTime inputDate;

    public Book(String title, String name, List<String> authors, String category, String isbn, LocalDateTime inputDate) {
        this.title = title;
        this.name = name;
        this.authors = authors;
        this.category = category;
        this.isbn = isbn;
        this.inputDate = inputDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getInputDate() {
        return inputDate;
    }

}
