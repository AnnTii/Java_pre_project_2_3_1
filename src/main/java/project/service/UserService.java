package project.service;

import project.model.User;
import java.util.List;

public interface UserService {

    List<User> get();
    void save(User user);
    void delete(int id);
    void update(int id, User user);
    User show(int id);
}
