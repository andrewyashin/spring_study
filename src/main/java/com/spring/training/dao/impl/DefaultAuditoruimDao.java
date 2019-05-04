package com.spring.training.dao.impl;

import com.spring.training.dao.AuditoriumDao;
import com.spring.training.domain.Auditorium;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Repository("auditoriumDao")
public class DefaultAuditoruimDao implements AuditoriumDao {
    private static final String AUDITORIUMS_FILE = "classpath:auditoriums.csv";
    private static final int NAME_INDEX = 0;
    private static final int NUMBER_OF_SEATS_INDEX = 1;
    private static final int VIP_SEATS_INDEX = 2;
    private static final String FILE_LINE_SEPARATOR = ";";
    private static final String VIP_SEATS_SEPARATOR = ",";

    private static final HashSet<Auditorium> auditoriums = new HashSet<>();

    static {
        try (BufferedReader reader = new BufferedReader(new FileReader(ResourceUtils.getFile(AUDITORIUMS_FILE)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(FILE_LINE_SEPARATOR);
                Auditorium auditorium = new Auditorium();
                auditorium.setName(lineParts[NAME_INDEX]);
                auditorium.setNumberOfSeats(Long.parseLong(lineParts[NUMBER_OF_SEATS_INDEX]));

                String[] vipSeats = lineParts[VIP_SEATS_INDEX].split(VIP_SEATS_SEPARATOR);
                Set<Long> resultVipSeats = new HashSet<>();
                Arrays.stream(vipSeats).forEach(seat -> resultVipSeats.add(Long.parseLong(seat)));
                auditorium.setVipSeats(resultVipSeats);

                auditoriums.add(auditorium);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Auditorium> getAll() {
        return new HashSet<>(auditoriums);
    }

    @Override
    public Auditorium getByName(String name) {
        return auditoriums.stream()
                .filter(auditorium -> name.equals(auditorium.getName()))
                .findFirst().orElse(null);
    }
}
