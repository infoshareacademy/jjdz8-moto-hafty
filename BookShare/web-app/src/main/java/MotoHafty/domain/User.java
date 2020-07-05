package MotoHafty.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

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
    @Transient
    private Set<Integer> userLibrary;
    @Transient
    private Set<Integer> userShelf;
    @Id
    private Long id;

    public User(){}

    public User(String login, String name, String surname, String email, String password, boolean isActive, Set<Integer> userLibrary, Set<Integer> userShelf) {
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

    public Set<Integer> getUserLibrary() {
        return userLibrary;
    }

    public void setUserLibrary(Set<Integer> userLibrary) {
        this.userLibrary = userLibrary;
    }

    public Set<Integer> getUserShelf() {
        return userShelf;
    }

    public void setUserShelf(Set<Integer> userShelf) {
        this.userShelf = userShelf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
