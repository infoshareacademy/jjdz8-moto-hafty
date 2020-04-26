package MotoHafty.domain;

import java.util.Set;

public class User {

    private String login;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Adress adress;
    private boolean isActive;
    private Set<Integer> userLibrary;
    private Set<Integer> userShelf;

    //FIXME gettery itd


    public User(String login, String name, String surname, String email, String password, Adress adress, boolean isActive, Set<Integer> userLibrary, Set<Integer> userShelf) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.adress = adress;
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
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
}
