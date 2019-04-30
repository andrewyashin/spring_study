package com.spring.training.service.impl;

import com.spring.training.domain.Event;
import com.spring.training.service.EventService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/config/config.xml")
public class EventServiceIntegrationTest {

    private static final String NAME = "name";

    @Autowired
    private EventService eventService;

    @Test
    public void shouldCreateEvent() {
        assertNotNull(eventService.createEvent(NAME));
    }

    @Test
    public void shouldGetEvent() {
        eventService.createEvent(NAME);
        assertNotNull(eventService.getByName(NAME));
    }

    @Test
    public void shouldCreateAndDeleteEvent() {
        Event event = eventService.createEvent(NAME);
        assertNotNull(event);
        assertNotNull(eventService.getByName(NAME));
        eventService.remove(event);
        assertNull(eventService.getByName(NAME));
    }

    @After
    public void cleanUp(){
        eventService.remove(eventService.getByName(NAME));
    }

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
