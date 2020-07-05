package MotoHafty.storage;

import MotoHafty.domain.User;

import javax.ejb.Stateless;
import java.util.*;

@Stateless
public class UserInMemoryDb implements UserDb {

    private Integer id = 1;
    private Map<Integer, User> users = new LinkedHashMap<>();

    public UserInMemoryDb() {
        importUsersFromJson();
    }

    @Override
    public Map<Integer, User> getAllUsers() {
        new UserInMemoryDb();
        return users;
    }

    private void importUsersFromJson(){
        List<User> userList = new ArrayList<>();
        //FIXME przechowywanie haseł - encrpyting
        userList.add(new User("ancymon","Jarek", "Szczepanik", "jarovo@go2.pl", "haslo1", true, new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)) ,new HashSet<>(Arrays.asList(1, 3, 4, 5, 7))));
        userList.add(new User("sabina","Sabina", "Pontikos", "wymyslony@o2.pl", "haslo2", true, new HashSet<>(Arrays.asList(4, 3)) ,new HashSet<>(Arrays.asList(3))));
        userList.add(new User("dominik","Dominik", "Rynkiewicz", "innyemail@o2.pl", "haslo3", true, new HashSet<>(Arrays.asList(1, 2, 3,7)) ,new HashSet<>(Arrays.asList(7,2))));
        userList.add(new User("mareczek","Marek", "Landowski", "mareczekcukiereczek@o2.pl", "haslo4", true, new HashSet<>(Arrays.asList(3)) ,new HashSet<>()));
        for (User user : userList) {
            users.put(id, user);
            id++;
        }
    }
}
