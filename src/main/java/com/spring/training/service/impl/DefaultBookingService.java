package com.spring.training.service.impl;

import com.spring.training.domain.Event;
import com.spring.training.domain.Ticket;
import com.spring.training.domain.User;
import com.spring.training.service.BookingService;
import com.spring.training.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Set;

@Service("bookingService")
public class DefaultBookingService implements BookingService {

    @Autowired
    private DiscountService discountService;


    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
        final byte discount = discountService.getDiscount(user, event, dateTime, seats.size());
        double totalPrice = 0d;
        if (event.getAirDates().contains(dateTime)) {
            totalPrice = event.getBasePrice() * seats.size();
        }

        double totalPriceWithDiscount = totalPrice - (totalPrice * ((double)discount / 100));
        return totalPriceWithDiscount;
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
        tickets.stream().filter(this::validateTicket).forEach(ticket -> ticket.getUser().getTickets().add(ticket));
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return null;
    }

    private boolean validateTicket(Ticket ticket) {
        boolean isValid = true;

        if (ticket.getUser() == null)
            isValid = false;

        if (ticket.getEvent() == null)
            isValid = false;

        if (ticket.getDateTime() == null)
            isValid = false;

        if (ticket.getSeat() == 0)
            isValid = false;

        return isValid;
    }
}
