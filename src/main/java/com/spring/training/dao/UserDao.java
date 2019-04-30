package com.spring.training.dao;

import com.spring.training.domain.User;

public interface UserDao extends AbstractDaoIntr<User> {
    User getUserByEmail(String email);
}
