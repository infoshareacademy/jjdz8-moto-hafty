package MotoHafty.storage;

import MotoHafty.domain.Book;
import MotoHafty.domain.User;

import java.util.Map;

public interface UserDb {

    Map<Integer, User> getAllUsers();

}
