package MotoHafty;

import java.time.LocalDateTime;
import java.util.List;

public class Book {

    //do obgadania czy inputDate w stringu czy w LDT

    private String title;
    private String name;
    private List<String> authors;
    private String category;
    private String isbn;
    private String inputDate;
    private Boolean isRead;
    private String description;

    public Book(String title, String name, List<String> authors, String category, String isbn, String inputDate, Boolean isRead, String description) {
        this.title = title;
        this.name = name;
        this.authors = authors;
        this.category = category;
        this.isbn = isbn;
        this.inputDate = inputDate;
        this.isRead = isRead;
        this.description = description;
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

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
