package MotoHafty.storage;

import MotoHafty.domain.Book;
import MotoHafty.domain.User;

import javax.ejb.Local;
import java.util.Map;

@Local
public interface UserDb {

    Map<Integer, User> getAllUsers();

}
