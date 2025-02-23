package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Cart;
import com.FindMyRoom.repository.CartRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CartRepositoryImpl implements CartRepository {

    @Override
    @NotNull
    public <S extends Cart> S save(@NotNull S entity) {
        return null;
    }

    @Override
    @NotNull
    public <S extends Cart> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @Override
    @NotNull
    public Optional<Cart> findById(@NotNull Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Long aLong) {
        return false;
    }

    @Override
    @NotNull
    public Iterable<Cart> findAll() {
        return null;
    }

    @Override
    @NotNull
    public Iterable<Cart> findAllById(@NotNull Iterable<Long> longs) {
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
    public void delete(@NotNull Cart entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends Cart> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
