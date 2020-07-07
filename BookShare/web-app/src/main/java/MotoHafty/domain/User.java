package MotoHafty.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String login;
    @Basic
    private String name;
    @Basic
    private String surname;
    @Basic
    private String email;
    @Basic
    private String password;
    @Basic
    private boolean isActive;
    @ManyToMany
    @JoinTable(name = "Users_Books_Library",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Set<Book> userLibrary;
    @ManyToMany
    @JoinTable(name = "Users_Books_Shelf",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Set<Book> userShelf;

    public User(){}

    public User(String login, String name, String surname, String email, String password, boolean isActive, Set<Book> userLibrary, Set<Book> userShelf) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.userLibrary = userLibrary;
        this.userShelf = userShelf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Book> getUserLibrary() {
        return userLibrary;
    }

    public void setUserLibrary(Set<Book> userLibrary) {
        this.userLibrary = userLibrary;
    }

    public Set<Book> getUserShelf() {
        return userShelf;
    }

    public void setUserShelf(Set<Book> userShelf) {
        this.userShelf = userShelf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
