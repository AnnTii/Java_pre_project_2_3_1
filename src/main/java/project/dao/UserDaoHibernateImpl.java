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
    public List<User> get() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class,id));
    }

    @Override
    public void update(int id, User user) {
        User us = show(id);
        us.setName(user.getName());
        us.setLastName(user.getLastName());
        us.setEmail(user.getEmail());
        us.setAge(user.getAge());
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }
}
