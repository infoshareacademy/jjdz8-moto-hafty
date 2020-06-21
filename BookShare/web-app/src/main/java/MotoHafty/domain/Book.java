package MotoHafty.domain;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table (name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author mainAuthor;

    @ManyToMany
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn (name = "author_id"),
            inverseJoinColumns = @JoinColumn (name = "book_id")
    )
    private Set<Author> authors = new HashSet<>();

    @Basic
    private String category;

    @Basic
    private String isbn;

    @Column(name = "input_date")
    private String inputDate;

    @Column(name = "is_read")
    private Boolean isRead;
    private String description;
    private String imgUrl;

    public Book(){}

    public Book(String title, String mainAuthorName, List<String> authors, String category, String isbn, String inputDate, Boolean isRead, String description, String imgUrl) {
        this.title = title;
        this.mainAuthor = new Author(mainAuthorName);
        this.authors = authors.stream().map(Author::new).collect(Collectors.toSet());
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

    public Author getMainAuthor() {
        return mainAuthor;
    }

    public void setMainAuthor(Author mainAuthor) {
        this.mainAuthor = mainAuthor;
    }

    public void setAuthorsFromList(List<String> authors) {
        this.authors = authors.stream().map((name) -> (new Author(name))).collect(Collectors.toSet());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getAuthorsNamesInList() {
        return this.authors.stream().map(Author::getName).collect(Collectors.toList());
    }

    public void setMainAuthorNameFromString(String name) {
        this.mainAuthor = new Author(name);
    }

}
