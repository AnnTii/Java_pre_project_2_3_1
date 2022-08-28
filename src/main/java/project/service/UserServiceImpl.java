package project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDao;
import project.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    UserServiceImpl (UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUser() {
        return userDao.getUser();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void dellUser(int id) {
        userDao.dellUser(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }
    @Override
    public User showId(int id) {
        return userDao.showId(id);
    }
}
