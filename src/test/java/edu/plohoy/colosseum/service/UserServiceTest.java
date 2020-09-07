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

        Mockito.doReturn(new User())
                .when(dao)
                .findByUsername("John");

        boolean isUserCreated = service.addUser(user);

        Assert.assertFalse(isUserCreated);
    }
}