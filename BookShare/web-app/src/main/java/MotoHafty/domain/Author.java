package MotoHafty.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Authors")
public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String authorName;
    @Basic
    private String authorSurname;
    @ManyToMany (mappedBy = "authors")
    private Set<Book> books;


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
