package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Admin;
import com.FindMyRoom.model.Cart;
import com.FindMyRoom.repository.CartRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CartRepositoryImpl implements CartRepository {

    @Override
    public <S extends Cart> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Cart> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Cart> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Cart> findAll() {
        return null;
    }

    @Override
    public Iterable<Cart> findAllById(Iterable<Long> longs) {
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
    public void delete(Cart entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cart> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
