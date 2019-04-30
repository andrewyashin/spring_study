package com.spring.training.dao.impl;

import com.spring.training.dao.AbstractDaoIntr;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractDao<T> implements AbstractDaoIntr<T> {
    private Set<T> objects = new HashSet<>();

    @Override
    public T save(T object) {
        objects.add(object);
        return object;
    }

    @Override
    public void remove(T object) {
        objects.remove(object);
    }

    @Override
    public Set<T> getAll() {
        return objects;
    }

    @Override
    public T getById(Long id) {
        return null;
    }
}
