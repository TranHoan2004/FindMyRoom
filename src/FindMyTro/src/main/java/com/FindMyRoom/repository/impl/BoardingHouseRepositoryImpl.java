package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Admin;
import com.FindMyRoom.model.BoardingHouse;
import com.FindMyRoom.repository.BoardingHouseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class BoardingHouseRepositoryImpl implements BoardingHouseRepository {

    @Override
    public <S extends BoardingHouse> S save(S entity) {
        return null;
    }

    @Override
    public <S extends BoardingHouse> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<BoardingHouse> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<BoardingHouse> findAll() {
        return null;
    }

    @Override
    public Iterable<BoardingHouse> findAllById(Iterable<Long> longs) {
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
    public void delete(BoardingHouse entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends BoardingHouse> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
