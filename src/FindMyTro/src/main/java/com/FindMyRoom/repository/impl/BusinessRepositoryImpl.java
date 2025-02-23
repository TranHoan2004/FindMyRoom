package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Business;
import com.FindMyRoom.repository.BusinessRepository;
import jakarta.persistence.EntityManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class BusinessRepositoryImpl implements BusinessRepository {
    private final EntityManager em;

    public BusinessRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @NotNull
    public <S extends Business> S save(@NotNull S entity) {
        return null;
    }

    @Override
    @NotNull
    public <S extends Business> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @Override
    @NotNull
    public Optional<Business> findById(@NotNull Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Long aLong) {
        return false;
    }

    @Override
    @NotNull
    public Iterable<Business> findAll() {
        return null;
    }

    @Override
    @NotNull
    public Iterable<Business> findAllById(@NotNull Iterable<Long> longs) {
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
    public void delete(@NotNull Business entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends Business> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
