package com.spring.training.service.impl;

import com.spring.training.dao.UserDao;
import com.spring.training.domain.User;
import com.spring.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

@Service("userService")
public class DefaultUserService implements UserService {

    @Autowired
    private UserDao userDao;

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User save(@Nonnull User object) {
        return userDao.save(object);
    }

    @Override
    public void remove(@Nonnull User object) {
        userDao.remove(object);
    }

    @Override
    public User getById(@Nonnull Long id) {
        return userDao.getById(id);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return userDao.getAll();
    }
}
