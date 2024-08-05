package by.itclass.model.services;

import by.itclass.model.dao.UserDao;
import by.itclass.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultUserService implements UserService{
    private UserDao dao;

    @Autowired
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<User> getAllUser() {
        return dao.selectAllUser();
    }

    @Override
    public void deleteById(int id) {
        dao.removeById(id);
    }

    @Override
    public void add(User user) {
        dao.insert(user);
    }
}
