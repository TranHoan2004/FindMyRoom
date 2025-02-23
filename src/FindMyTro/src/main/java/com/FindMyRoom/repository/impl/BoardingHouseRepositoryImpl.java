package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.BoardingHouse;
import com.FindMyRoom.repository.BoardingHouseRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class BoardingHouseRepositoryImpl implements BoardingHouseRepository {

    @NotNull
    @Override
    public <S extends BoardingHouse> S save(@NotNull S entity) {
        return null;
    }

    @NotNull
    @Override
    public <S extends BoardingHouse> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @NotNull
    @Override
    public Optional<BoardingHouse> findById(@NotNull Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Long aLong) {
        return false;
    }

    @NotNull
    @Override
    public Iterable<BoardingHouse> findAll() {
        return null;
    }

    @NotNull
    @Override
    public Iterable<BoardingHouse> findAllById(@NotNull Iterable<Long> longs) {
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
    public void delete(@NotNull BoardingHouse entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends BoardingHouse> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
