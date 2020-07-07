package MotoHafty.domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String title;
    @Basic
    private String mainAuthorName;
    @ManyToMany
    @JoinTable(name = "Authors_Books",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private List<Author> authors = new LinkedList<>();
    @Basic
    private String category;
    @Basic
    private String isbn;
    @Basic
    private String inputDate;
    @Basic
    private Boolean isRead;
    @Basic
    private String description;
    @Basic
    private String imgUrl;
    @ManyToMany (mappedBy = "userLibrary")
    private Set<User> libraries;
    @ManyToMany (mappedBy = "userShelf")
    private Set<User> shelfs;

    public Book() {
    }

    public Book(String title, String mainAuthorName, List<Author> authors, String category, String isbn, String inputDate, Boolean isRead, String description, String imgUrl) {
        this.title = title;
        this.mainAuthorName = mainAuthorName;
        this.authors = authors;
        this.category = category;
        this.isbn = isbn;
        this.inputDate = inputDate;
        this.isRead = isRead;
        this.description = description;
        this.imgUrl = imgUrl;
    }

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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
