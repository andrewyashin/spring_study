package com.spring.training.dao.impl;

import com.spring.training.dao.EventDao;
import com.spring.training.domain.Event;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

@Repository("eventDao")
public class DefaultEventDao implements EventDao {
    private static final List<Event> events = new ArrayList<>();

    @Override
    public Event getEvent(@Nonnull String name) {
        return events.stream().filter(e -> name.equals(e.getName())).findFirst().orElse(null);
    }

    @Override
    public Event save(Event event) {
        events.add(event);
        return event;
    }

    @Override
    public boolean delete(Event event) {
        events.remove(event);
        return true;
    }
}
