package com.spring.training.dao;

import java.util.Set;

public interface AbstractDaoIntr<T> {
    T save(T event);

    void remove(T event);

    Set<T> getAll();

    T getById(Long id);
}
