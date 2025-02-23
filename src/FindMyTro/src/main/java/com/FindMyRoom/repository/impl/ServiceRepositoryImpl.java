package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Service;
import com.FindMyRoom.repository.ServiceRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class ServiceRepositoryImpl implements ServiceRepository {

    @Override
    @NotNull
    public <S extends Service> S save(@NotNull S entity) {
        return null;
    }

    @Override
    @NotNull
    public <S extends Service> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @Override
    @NotNull
    public Optional<Service> findById(@NotNull Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Long aLong) {
        return false;
    }

    @Override
    @NotNull
    public Iterable<Service> findAll() {
        return null;
    }

    @Override
    @NotNull
    public Iterable<Service> findAllById(@NotNull Iterable<Long> longs) {
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
    public void delete(@NotNull Service entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends Service> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
