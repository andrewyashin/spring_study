package com.spring.training.service.impl;

import com.spring.training.domain.Event;
import com.spring.training.service.EventService;
import org.junit.After;
import org.junit.Before;
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
    private Event event;

    @Autowired
    private EventService eventService;

    @Before
    public void setUp() {
        event = new Event();
        event.setName(NAME);
    }

    @After
    public void cleanUp() {
        eventService.remove(event);
    }

    @Test
    public void shouldSaveEvent() {
        assertNotNull(eventService.save(event));
    }

    @Test
    public void shouldGetEvent() {
        eventService.save(event);
        assertNotNull(eventService.getByName(NAME));
    }

    @Test
    public void shouldCreateAndDeleteEvent() {
        Event resultEvent = eventService.save(event);
        assertNotNull(resultEvent);
        assertNotNull(eventService.getByName(NAME));
        eventService.remove(resultEvent);
        assertNull(eventService.getByName(NAME));
    }
}
