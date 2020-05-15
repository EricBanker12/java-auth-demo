package demo.auth.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.longThat;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import demo.auth.AuthApplication;
import demo.auth.models.User;
import demo.auth.repositories.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AuthApplication.class)
public class UserServiceImplTest {

    @MockBean
    UserRepository userRepository;
    
    @Autowired
    UserServiceImpl userService;

    @Test
    void findAllTest() {
        Mockito
            .when(userRepository.findAll())
            .thenReturn(Arrays.asList(new User("user", "pass")));

        List<User> users = userService.findAll();

        assertEquals(1, users.size(), "user count is not 1");
        assertEquals("user", users.get(0).getUsername(), "username is not \"user\"");
        assertEquals("pass", users.get(0).getPassword(), "password is not \"pass\"");
    }

    @Test
    void findByIdTest() {
        User user = new User("user", "pass");
        user.setId(1L);

        Mockito
            .when(userRepository.findById(longThat(id -> id == 1L)))
            .thenReturn(Optional.of(user));

        User testuser = userService.findById(1L);

        assertEquals(1L, testuser.getId(), "user id is not 1");
        assertEquals("user", testuser.getUsername(), "username is not \"user\"");
        assertEquals("pass", testuser.getPassword(), "password is not \"pass\"");
    }

    @Test
    void findById_BadIdThrowsExceptionTest() {
        Optional<User> empty = Optional.empty();

        Mockito
            .when(userRepository.findById(anyLong()))
            .thenReturn(empty);

        assertThrows(NoSuchElementException.class, () -> userService.findById(1L));
    }

}