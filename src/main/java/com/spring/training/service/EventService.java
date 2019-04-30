package com.spring.training.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.spring.training.domain.Event;

import java.time.LocalDate;
import java.util.Set;


public interface EventService extends AbstractDomainObjectService<Event> {

    /**
     * Finding event by name
     * 
     * @param name
     *            Name of the event
     * @return found event or <code>null</code>
     */
    @Nullable Event getByName(@Nonnull String name);
}
