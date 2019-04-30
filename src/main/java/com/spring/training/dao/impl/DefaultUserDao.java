package com.spring.training.dao.impl;

import com.spring.training.dao.UserDao;
import com.spring.training.domain.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;

@Repository("userDao")
public class DefaultUserDao extends AbstractDao<User> implements UserDao {
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return getAll().stream().filter(user -> email.equals(user.getEmail())).findFirst().orElse(null);
    }
}
