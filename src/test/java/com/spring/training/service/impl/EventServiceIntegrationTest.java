package com.spring.training.service.impl;

import com.spring.training.service.EventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/config/config.xml")
public class EventServiceIntegrationTest {

    @Autowired
    private EventService eventService;

    @Test
    public void shouldCreateEvent() {
        assertNotNull(eventService.createEvent("name"));
    }

    @Qualifier(value = "eventService")
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
}
