package MotoHafty.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    @OneToMany(mappedBy = "mainAuthor")
    private Set<Book> booksMainAuthor = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooksMainAuthor() {
        return booksMainAuthor;
    }

    public void setBooksMainAuthor(Set<Book> booksMainAuthor) {
        this.booksMainAuthor = booksMainAuthor;
    }

    public Author() {

    }

    public Author(String name) {
        this.name = name;
    }
}
