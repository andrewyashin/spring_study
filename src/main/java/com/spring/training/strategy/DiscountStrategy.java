package com.spring.training.strategy;

import com.spring.training.domain.Event;
import com.spring.training.domain.User;

import java.time.LocalDateTime;

public interface DiscountStrategy {
    byte apply(User user, Event event, LocalDateTime airDateTime, long numberOfTickets);
}
