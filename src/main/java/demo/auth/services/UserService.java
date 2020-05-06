package demo.auth.services;

import java.util.List;

import demo.auth.models.User;

public interface UserService {

    List<User> findAll();

    User findById(long id);

    User findByUsername(String username);

    User save(User user);

    void delete(long id);

    User update(User user, long id);

}