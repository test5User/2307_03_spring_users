package by.itclass.model.dao;

import by.itclass.model.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultUserDao implements UserDao{
    private SessionFactory factory;

    @Autowired
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> selectAllUser() {
        try (var session = factory.openSession()){
            return session.createQuery("from User", User.class).list();
        }
    }

    @Override
    public void removeById(int id) {
        try (var session = factory.openSession()){
            var transaction = session.beginTransaction();
            var user = session.get(User.class, id);
            session.remove(user);
            transaction.commit();
        }
    }

    @Override
    public void insert(User user) {
        try (var session = factory.openSession()){
            var transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
    }

    @Override
    public void update(User user) {
        try (var session = factory.openSession()){
            var tr = session.beginTransaction();
            session.update(user);
            tr.commit();
        }
    }
}
