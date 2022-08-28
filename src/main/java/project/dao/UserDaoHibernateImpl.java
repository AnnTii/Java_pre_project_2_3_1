package project.dao;

import org.springframework.stereotype.Repository;
import project.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUser() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void dellUser(int id) {
        entityManager.remove(entityManager.find(User.class,id));
    }

    @Override
    public void updateUser(int id, User user) {
        User us = showId(id);
        us.setName(user.getName());
        us.setLastName(user.getLastName());
        us.setMail(user.getMail());
        us.setAge(user.getAge());
    }

    @Override
    public User showId(int id) {
        return entityManager.find(User.class, id);
    }
}
