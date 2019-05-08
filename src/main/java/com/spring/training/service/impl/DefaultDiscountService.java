package com.spring.training.service.impl;

import com.spring.training.domain.Event;
import com.spring.training.domain.User;
import com.spring.training.service.DiscountService;
import com.spring.training.strategy.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service("discountService")
public class DefaultDiscountService implements DiscountService {

    @Autowired
    private List<DiscountStrategy> discountStrategies;

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        return discountStrategies.stream()
                .map(strategy -> strategy.apply(user, event, airDateTime, numberOfTickets))
                .collect(Collectors.toList()).stream().max(Byte::compare).orElse(new Byte("0"));
    }
}
