package MotoHafty.storage;

import MotoHafty.domain.Adress;
import MotoHafty.domain.Province;
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
        return users;
    }

    private void importUsersFromJson(){
        List<User> userList = new ArrayList<>();
        //FIXME przechowywanie haseł - encrpyting
        userList.add(new User("ancymon","Jarek", "Szczepanik", "jarovo@go2.pl", "haslo1", new Adress("Ćwiartki 3/4", "Wrocław", Province.DOLNOŚLĄSKIE, "50-001"), true, new HashSet<>(Arrays.asList(1, 2, 3)) ,new HashSet<>(Arrays.asList(1))));
        userList.add(new User("sabina","Sabina", "Pontikos", "wymyslony@o2.pl", "haslo2", new Adress("Sezamkowa 16", "Mordor", Province.POMORSKIE, "12-224"), true, new HashSet<>(Arrays.asList(4, 3)) ,new HashSet<>(Arrays.asList(3))));
        userList.add(new User("dominik","Dominik", "Rynkiewicz", "innyemail@o2.pl", "haslo3", new Adress("Dolina Łez i Rozpaczy 23ab/5", "Elbląg", Province.WARMIŃSKO_MAZURSKIE, "82-300"), true, new HashSet<>(Arrays.asList(1, 2, 3,7)) ,new HashSet<>(Arrays.asList(7,2))));
        userList.add(new User("mareczek","Marek", "Landowski", "mareczekcukiereczek@o2.pl", "haslo4", new Adress("Plastikowa 1", "Paryż", Province.OTHER, "12-666"), true, new HashSet<>(Arrays.asList(3)) ,new HashSet<>()));
        for (User user : userList) {
            getAllUsers().put(id, user);
            id++;
        }
    }
}
