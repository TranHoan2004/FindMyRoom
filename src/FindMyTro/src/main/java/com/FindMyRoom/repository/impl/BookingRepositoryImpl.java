package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Booking;
import com.FindMyRoom.repository.BookingRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class BookingRepositoryImpl implements BookingRepository {

    @Override
    @NotNull
    public <S extends Booking> S save(@NotNull S entity) {
        return null;
    }

    @Override
    @NotNull
    public <S extends Booking> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @Override
    @NotNull
    public Optional<Booking> findById(@NotNull Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Long aLong) {
        return false;
    }

    @Override
    @NotNull
    public Iterable<Booking> findAll() {
        return null;
    }

    @Override
    @NotNull
    public Iterable<Booking> findAllById(@NotNull Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(@NotNull Long aLong) {

    }

    @Override
    public void delete(@NotNull Booking entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends Booking> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
