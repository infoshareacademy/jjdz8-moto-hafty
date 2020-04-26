package MotoHafty.storage;

import MotoHafty.domain.Adress;
import MotoHafty.domain.User;

import javax.ejb.Stateful;
import java.util.*;

@Stateful
public class UserInMemoryDb implements UserDb {

    private Integer id = 1;
    private Map<Integer, User> users = new LinkedHashMap<>();

    public UserInMemoryDb() {
        importUsersFromJson();
    }

    @Override
    public Map<Integer, User> getAllUsers() {
        return users;
    }

    //FIXME zaimplementować zasysacz z jsonów
    private void importUsersFromJson(){
        List<User> userList = new ArrayList<>();
        //FIXME hasła
        userList.add(new User("ancymon","Jarek", "Szczepanik", "jarovo@go2.pl", "haslo1", new Adress(), true, new HashSet<>(Arrays.asList(1, 2, 3)) ,new HashSet<>(Arrays.asList(1))));
        userList.add(new User("sabina","Sabina", "Pontikos", "wymyslony@o2.pl", "haslo2", new Adress(), true, new HashSet<>(Arrays.asList(4, 3)) ,new HashSet<>(Arrays.asList(3))));
        userList.add(new User("dominik","Dominik", "Rynkiewicz", "innyemail@o2.pl", "haslo3", new Adress(), true, new HashSet<>(Arrays.asList(1, 2, 3,7)) ,new HashSet<>(Arrays.asList(7,2))));
        userList.add(new User("mareczek","Marek", "Landowski", "mareczekcukiereczek@o2.pl", "haslo4", new Adress(), true, new HashSet<>(Arrays.asList(3)) ,new HashSet<>()));
        for (User user : userList) {
            getAllUsers().put(id, user);
            id++;
        }
    }
}
