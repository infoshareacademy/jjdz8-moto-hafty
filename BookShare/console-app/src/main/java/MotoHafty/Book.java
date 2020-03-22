package MotoHafty;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Book  extends Menu{

    private String title;
    private String mainAuthorName;
    private List<String> authors = new LinkedList<>();
    private String category;
    private String isbn;
    private String inputDate;
    private Boolean isRead;
    private String description;

    public Book(){};

    public Book(String title, String mainAuthorName, List<String> authors, String category, String isbn, String inputDate, Boolean isRead, String description) {
        this.title = title;
        this.mainAuthorName = mainAuthorName;
        this.authors = authors;
        this.category = category;
        this.isbn = isbn;
        this.inputDate = inputDate;
        this.isRead = isRead;
        this.description = description;
    }

    Scanner scanner = new Scanner(System.in);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainAuthorName() {
        return mainAuthorName;
    }

    public void setMainAuthorName(String mainAuthorName) {
        this.mainAuthorName = mainAuthorName;
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
