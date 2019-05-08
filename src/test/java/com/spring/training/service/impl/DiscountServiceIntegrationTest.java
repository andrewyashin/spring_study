package com.spring.training.service.impl;

import com.spring.training.domain.Event;
import com.spring.training.domain.User;
import com.spring.training.service.DiscountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/config/config.xml")
public class DiscountServiceIntegrationTest {

    @Autowired
    private DiscountService discountService;

    @Test
    public void shouldApplyDiscountIfBirthdayInTimeRange() {
        User user = new User();
        user.setBirthday(LocalDateTime.now().withYear(1997).withMonth(1).withDayOfMonth(12));
        LocalDateTime airDateTime = LocalDateTime.now().withYear(2019).withMonth(1).withDayOfMonth(14);
        byte resultDiscount = discountService.getDiscount(user, new Event(), airDateTime, 1);
        assertEquals(20, resultDiscount);
    }

    @Test
    public void shouldNotApplyDiscountIfBirthdayNotInTimeRange() {
        User user = new User();
        user.setBirthday(LocalDateTime.now().withYear(2019).withMonth(3).withDayOfMonth(12));
        LocalDateTime airDateTime = LocalDateTime.now().withYear(2019).withMonth(1).withDayOfMonth(14);
        byte resultDiscount = discountService.getDiscount(user, new Event(), airDateTime, 1);
        assertEquals(0, resultDiscount);
    }


    @Test
    public void shouldApplyDiscountForTenTicket() {
        LocalDateTime airDateTime = LocalDateTime.now().withYear(2019).withMonth(1).withDayOfMonth(14);
        byte resultDiscount = discountService.getDiscount(null, new Event(), airDateTime, 10);
        assertEquals(5, resultDiscount);
    }

    @Test
    public void shouldApplyMaxBirthdayDiscount() {
        User user = new User();
        user.setBirthday(LocalDateTime.now().withYear(2019).withMonth(1).withDayOfMonth(12));

        LocalDateTime airDateTime = LocalDateTime.now().withYear(2019).withMonth(1).withDayOfMonth(14);
        byte resultDiscount = discountService.getDiscount(user, new Event(), airDateTime, 30);
        assertEquals(20, resultDiscount);
    }

}
