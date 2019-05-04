package com.spring.training.dao;

import java.util.Set;

public interface AbstractDaoIntr<T> {
    T save(T object);

    void remove(T object);

    Set<T> getAll();

    T getById(Long id);
}
