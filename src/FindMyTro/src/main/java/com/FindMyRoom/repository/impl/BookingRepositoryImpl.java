package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Admin;
import com.FindMyRoom.model.Booking;
import com.FindMyRoom.repository.BookingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class BookingRepositoryImpl implements BookingRepository {

    @Override
    public <S extends Booking> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Booking> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Booking> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Booking> findAll() {
        return null;
    }

    @Override
    public Iterable<Booking> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Booking entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Booking> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
