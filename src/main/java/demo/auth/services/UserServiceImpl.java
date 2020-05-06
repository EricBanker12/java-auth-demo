package demo.auth.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.auth.models.User;
import demo.auth.repositories.UserRepository;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository users;

    @Override
    public List<User> findAll() {
        List<User> usersList = new ArrayList<>();
        users.findAll().iterator().forEachRemaining(usersList::add);
        return usersList;
    }

    @Override
    public User findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public User update(User user, long id) {
        // TODO Auto-generated method stub
        return null;
    }

}