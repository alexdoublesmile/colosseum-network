package edu.plohoy.colosseum.service;

import edu.plohoy.colosseum.domain.Role;
import edu.plohoy.colosseum.domain.User;
import edu.plohoy.colosseum.repos.UserRepo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
    private UserRepo repo;

    @MockBean
    private MailSender sender;

    @MockBean
    private PasswordEncoder encoder;

    @Test
    public void addUser() {
        User user = new User();
        boolean isCreated = service.addUser(user);

        Assert.assertTrue(isCreated);
        Assert.assertNotNull(user.getActivationCode());
        Assert.assertTrue(
                CoreMatchers
                .is(user.getRoles())
                .matches(Collections.singleton(Role.USER))
        );
    }
}