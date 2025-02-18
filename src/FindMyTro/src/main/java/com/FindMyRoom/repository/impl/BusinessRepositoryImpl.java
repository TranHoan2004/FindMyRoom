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
    public <S extends Business> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Business> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Business> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Business> findAll() {
        return null;
    }

    @Override
    public Iterable<Business> findAllById(Iterable<Long> longs) {
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
    public void delete(Business entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Business> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
