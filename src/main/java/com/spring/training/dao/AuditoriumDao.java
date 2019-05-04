package com.spring.training.dao;

import com.spring.training.domain.Auditorium;

import java.util.Set;

public interface AuditoriumDao {
    Set<Auditorium> getAll();
    Auditorium getByName(String name);
}
