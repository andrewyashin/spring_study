package com.spring.training.service.impl;

import com.spring.training.domain.User;
import com.spring.training.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/config/config.xml")
public class UserServiceIntegrationTest {
    private static final String EMAIL = "email";

    private User user;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        user = new User();
        user.setEmail(EMAIL);
    }

    @After
    public void cleanUp() {
        userService.remove(user);
    }

    @Test
    public void shouldSaveUser() {
        assertNotNull(userService.save(user));
    }

    @Test
    public void shouldGetUser() {
        userService.save(user);
        assertNotNull(userService.getUserByEmail(EMAIL));
    }

    @Test
    public void shouldCreateAndDeleteUser() {
        User resultUser = userService.save(user);
        assertNotNull(resultUser);
        assertNotNull(userService.getUserByEmail(EMAIL));
        userService.remove(resultUser);
        assertNull(userService.getUserByEmail(EMAIL));
    }

}