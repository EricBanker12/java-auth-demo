package demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import demo.auth.models.User;
import demo.auth.services.UserService;

@Component
@Transactional
public class SeedData implements CommandLineRunner {
    
    @Autowired
    UserService userService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        User user = new User("testuser", "password");

        userService.save(user);
    }

}