package com.spring.training.service.impl;

import com.spring.training.domain.Auditorium;
import com.spring.training.service.AuditoriumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/config/config.xml")
public class AuditoriumServiceIntegrationTest {

    @Autowired
    @Qualifier("auditoriumService")
    private AuditoriumService auditoriumService;

    @Test
    public void shouldReturnRightCountOfAuditoriums(){
        Set<Auditorium> auditoriums = auditoriumService.getAll();
        assertEquals(2, auditoriums.size());
    }


}
