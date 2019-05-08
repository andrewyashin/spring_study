package com.spring.training.strategy.impl;

import com.spring.training.domain.Event;
import com.spring.training.domain.User;
import com.spring.training.strategy.DiscountStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("everyTenTicketDiscountStrategy")
public class EveryTenTicketDiscountStrategy implements DiscountStrategy {
    @Value("{discount.every.ten.ticket}")
    private byte discount;

    @Override
    public byte apply(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
        if (numberOfTickets % 10 == 0)
            return discount;
        return 0;
    }
}
