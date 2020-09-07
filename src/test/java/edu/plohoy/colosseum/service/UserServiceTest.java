package edu.plohoy.colosseum.service;

import edu.plohoy.colosseum.domain.Role;
import edu.plohoy.colosseum.domain.User;
import edu.plohoy.colosseum.repos.UserRepo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService service;

    @MockBean
    private UserRepo dao;

    @MockBean
    private MailSender sender;

    @MockBean
    private PasswordEncoder encoder;

    @Test
    public void addUser() {
        User user = new User();
        user.setEmail("some@mail.ru");
        boolean isUserCreated = service.addUser(user);

        Assert.assertTrue(isUserCreated);
        Assert.assertNotNull(user.getActivationCode());
        Assert.assertTrue(
                CoreMatchers
                .is(user.getRoles())
                .matches(Collections.singleton(Role.USER))
        );

        Mockito.verify(dao, Mockito.times(1))
                .save(user);
        Mockito.verify(sender, Mockito.times(1))
                .send(
                        ArgumentMatchers.eq(user.getEmail()),
                        ArgumentMatchers.anyString(),
                        ArgumentMatchers.anyString()
                );
    }

    @Test
    public void addUserFail() {
        User user = new User();
        user.setUsername("John");

        Mockito.doReturn(user)
                .when(dao)
                .findByUsername("John");

        boolean isUserCreated = service.addUser(user);

        Assert.assertFalse(isUserCreated);
        Mockito.verify(dao, Mockito.times(0))
                .save(ArgumentMatchers.any(User.class));
        Mockito.verify(sender, Mockito.times(0))
                .send(
                        ArgumentMatchers.anyString(),
                        ArgumentMatchers.anyString(),
                        ArgumentMatchers.anyString()
                );
    }

    @Test
    public void activateUser() {
        User user = new User();
        user.setActivationCode("test Activation Code");

        Mockito.doReturn(user)
                .when(dao)
                .findByActivationCode("activate");

        boolean isUserActivated = service.activateUser("activate");

        Assert.assertTrue(isUserActivated);
        Assert.assertNull(user.getActivationCode());
        Mockito.verify(dao, Mockito.times(1))
                .save(user);
    }

    @Test
    public void activateUserFail() {
        boolean isUserActivated = service.activateUser("activate");

        Assert.assertFalse(isUserActivated);
        Mockito.verify(dao, Mockito.times(0))
                .save(ArgumentMatchers.any(User.class));
    }
}