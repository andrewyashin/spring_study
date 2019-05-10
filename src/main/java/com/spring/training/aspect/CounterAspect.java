package com.spring.training.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class CounterAspect {
    private static final Map<String, Long> counters = new HashMap<>();

    private static final String EVENT_GET_NAME_COUNTER = "GetNameCounter";
    private static final String EVENT_GET_BASE_PRICE_COUNTER = "GetBasePriceCounter";

    static {
        counters.put(EVENT_GET_NAME_COUNTER, 0L);
        counters.put(EVENT_GET_BASE_PRICE_COUNTER, 0L);
    }

    @AfterReturning("execution(* com.spring.training.domain.Event.getName())")
    public void countEventNameCall() {
        counters.put(EVENT_GET_NAME_COUNTER, counters.get(EVENT_GET_NAME_COUNTER) + 1);
    }

    @AfterReturning("execution(* com.spring.training.domain.Event.getBasePrice())")
    public void countEventBasePriceCall() {
        counters.put(EVENT_GET_NAME_COUNTER, counters.get(EVENT_GET_NAME_COUNTER) + 1);
    }
}
