package com.spring.training.service.impl;

import com.spring.training.dao.EventDao;
import com.spring.training.domain.Event;
import com.spring.training.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class DefaultEventService implements EventService {
    private EventDao eventDao;

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return eventDao.getEvent(name);
    }

    @Nullable
    @Override
    public Event createEvent(@Nonnull String name) {
        Event event = getByName(name);
        if (event == null) {
            Event newEvent = new Event();
            newEvent.setName(name);
            return save(newEvent);
        }
        return event;
    }

    @Override
    public Event save(@Nonnull Event object) {
        return eventDao.save(object);
    }

    @Override
    public void remove(@Nonnull Event object) {
        eventDao.delete(object);
    }

    @Override
    public Event getById(@Nonnull Long id) {
        return null;
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return null;
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }
}
