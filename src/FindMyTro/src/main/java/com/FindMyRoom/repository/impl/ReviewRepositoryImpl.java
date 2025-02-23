package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Review;
import com.FindMyRoom.repository.ReviewRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class ReviewRepositoryImpl implements ReviewRepository {

    @Override
    @NotNull
    public <S extends Review> S save(@NotNull S entity) {
        return null;
    }

    @Override
    @NotNull
    public <S extends Review> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @Override
    @NotNull
    public Optional<Review> findById(@NotNull Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Long aLong) {
        return false;
    }

    @Override
    @NotNull
    public Iterable<Review> findAll() {
        return null;
    }

    @Override
    @NotNull
    public Iterable<Review> findAllById(@NotNull Iterable<Long> longs) {
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
    public void delete(@NotNull Review entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends Review> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
