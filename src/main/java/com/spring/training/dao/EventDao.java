package com.spring.training.dao;

import com.spring.training.domain.Event;

public interface EventDao extends AbstractDaoIntr<Event> {
    Event getEvent(String name);
}
