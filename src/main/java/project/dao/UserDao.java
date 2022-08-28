package project.dao;

import project.model.User;
import java.util.List;

public interface UserDao {

    List<User> getUser();
    void saveUser(User user);
    void dellUser(int id);
    void updateUser(int id, User user);
    User showId(int id);
}
