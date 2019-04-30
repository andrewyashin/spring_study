package com.spring.training.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.spring.training.domain.User;


public interface UserService extends AbstractDomainObjectService<User> {
    @Nullable User getUserByEmail(@Nonnull String email);
}
