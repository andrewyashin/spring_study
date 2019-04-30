package com.spring.training.dao;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T> {
    private List<T> objects = new ArrayList<>();

    public T save(T object){
        objects.add(object);
        return object;
    }

    public void remove(T object){
        objects.remove(object);
    }

    protected List<T> getObjects(){
        return objects;
    }
}
