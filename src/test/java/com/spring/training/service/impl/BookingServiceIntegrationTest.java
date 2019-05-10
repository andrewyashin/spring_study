package com.spring.training.service.impl;

import com.spring.training.domain.Event;
import com.spring.training.domain.Ticket;
import com.spring.training.domain.User;
import com.spring.training.service.BookingService;
import com.spring.training.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/config/config.xml")
public class BookingServiceIntegrationTest {

    private static final String EVENT_NAME = "eventName";
    @Autowired
    @Qualifier("bookingService")
    private BookingService bookingService;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    private User currentUser;
    private Event event;
    private LocalDateTime eventTime = LocalDateTime.of(2019, 2, 2, 2, 0, 0, 0);

    @Before
    public void setUp() {
        currentUser = new User();
        currentUser.setBirthday(LocalDateTime.now().withYear(1990).withMonth(10).withDayOfMonth(10));

        event = new Event();
        event.setBasePrice(10d);
        event.setName(EVENT_NAME);
        NavigableSet<LocalDateTime> airDates = new TreeSet<>();
        airDates.add(eventTime);
        event.setAirDates(airDates);
    }

    @Test
    public void shouldReturnTotalPriceWithoutDiscountsForTickets() {
        final double actualTotalPrice = bookingService.getTicketsPrice(event,
                eventTime,
                currentUser,
                new HashSet<>(Arrays.asList(1L, 5L, 6L, 7L, 2L)));
        assertEquals(50d, actualTotalPrice, 0d);
    }

    @Test
    public void shouldReturnTotalPriceWithDiscountsForTickets() {
        currentUser.setBirthday(LocalDateTime.now().withYear(1990).withMonth(2).withDayOfMonth(2));

        final double actualTotalPrice = bookingService.getTicketsPrice(event,
                eventTime,
                currentUser,
                new HashSet<>(Arrays.asList(1L, 5L, 6L, 7L, 2L)));
        assertEquals(40d, actualTotalPrice, 0d);
    }

    @Test
    public void shouldBookTicketForUser() {
        userService.save(currentUser);

        Ticket ticket = new Ticket(currentUser, event, eventTime, 3L);
        bookingService.bookTickets(Collections.singleton(ticket));

        assertEquals(currentUser.getTickets().size(), 1);

    }
}
