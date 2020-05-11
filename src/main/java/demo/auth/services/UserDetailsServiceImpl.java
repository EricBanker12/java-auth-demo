package demo.auth.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import demo.auth.models.User;
import demo.auth.models.UserDetail;
import demo.auth.repositories.UserRepository;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository users;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws NoSuchElementException {
        User user = users.findByUsername(username).get();
        return new UserDetail(user);
    }
}