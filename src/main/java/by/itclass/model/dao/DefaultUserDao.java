package by.itclass.model.dao;

import by.itclass.model.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultUserDao implements UserDao{
    @Override
    public List<User> selectAllUser() {
        return new ArrayList<>();
    }
}
