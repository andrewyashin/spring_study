package com.spring.training.dao.impl;

import com.spring.training.dao.AbstractDao;
import com.spring.training.dao.EventDao;
import com.spring.training.domain.Event;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

@Repository("eventDao")
public class DefaultEventDao extends AbstractDao<Event> implements EventDao{
    @Override
    public Event getEvent(@Nonnull String name) {
        return getObjects().stream().filter(e -> name.equals(e.getName())).findFirst().orElse(null);
    }
}
