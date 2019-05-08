package com.spring.training.strategy.impl;

import com.spring.training.domain.Event;
import com.spring.training.domain.User;
import com.spring.training.strategy.DiscountStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Objects;

@Component("birthdayDiscountStrategy")
public class BirthdayDiscountStrategy implements DiscountStrategy {
    @Value("{discount.bitrhday}")
    private byte discount;

    @Override
    public byte apply(@Nullable User user, @Nonnull Event event, LocalDateTime airDateTime, long numberOfTickets) {
        if (Objects.nonNull(user)) {
            if (user.getBithdate().plusDays(5).isBefore(airDateTime)
                    && user.getBithdate().minusDays(5).isAfter(airDateTime))
                return discount;
        }
        return 0;
    }
}
