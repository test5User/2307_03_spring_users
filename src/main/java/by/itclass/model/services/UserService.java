package by.itclass.model.services;

import by.itclass.model.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void deleteById(int id);
    void add(User user);
    void upd(User user);
}
