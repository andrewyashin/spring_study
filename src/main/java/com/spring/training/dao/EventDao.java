package com.spring.training.dao;

import com.spring.training.domain.Event;

public interface EventDao {
    Event getEvent(String name);
    Event save(Event event);
    void remove(Event event);
}
