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
    public List<User> get() {
        return userDao.get();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDao.update(id, user);
    }
    @Override
    public User show(int id) {
        return userDao.show(id);
    }
}
