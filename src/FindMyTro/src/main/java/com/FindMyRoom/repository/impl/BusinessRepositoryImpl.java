package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Admin;
import com.FindMyRoom.model.Business;
import com.FindMyRoom.repository.BusinessRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
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
    public long count() {
        return 0;
    }

    @NotNull
    @Override
    public <S extends Business> S save(@NotNull S entity) {
        return null;
    }

    @NotNull
    @Override
    public <S extends Business> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @NotNull
    @Override
    public Optional<Business> findById(@NotNull Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Integer integer) {
        return false;
    }

    @NotNull
    @Override
    public Iterable<Business> findAll() {
        return em.unwrap(Session.class)
                .createQuery("from Business", Business.class)
                .list();
    }

    @NotNull
    @Override
    public Iterable<Business> findAllById(@NotNull Iterable<Integer> integers) {
        return null;
    }

    @Override
    public void deleteById(@NotNull Integer integer) {

    }

    @Override
    public void delete(@NotNull Business entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends Business> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
