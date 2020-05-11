package demo.auth.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import demo.auth.models.User;
import demo.auth.repositories.UserRepository;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository users;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        List<User> usersList = new ArrayList<>();
        users.findAll().iterator().forEachRemaining(usersList::add);
        return usersList;
    }

    @Override
    public User findById(long id) throws NoSuchElementException {
        User user = users.findById(id).get();
        return user;
    }

    @Override
    public User findByUsername(String username) throws NoSuchElementException {
        User user = users.findByUsername(username).get();
        return user;
    }

    @Transactional
    @Override
    public User save(User user) {
        String password = passwordEncoder.encode(user.getPassword());
        User newUser = new User(user.getUsername(), password);
        return users.save(newUser);
    }

    @Transactional
    @Override
    public void delete(long id) {
        users.deleteById(id);
    }

    @Transactional
    @Override
    public User update(User user, long id) {
        User currentUser = users.findById(id).get();
        if (user.getUsername() != null) {
            currentUser.setUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            String password = passwordEncoder.encode(user.getPassword());
            currentUser.setPassword(password);
        }
        return users.save(currentUser);
    }

}