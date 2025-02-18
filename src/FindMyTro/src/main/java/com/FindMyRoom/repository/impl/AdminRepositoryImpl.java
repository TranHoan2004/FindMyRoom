package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Admin;
import com.FindMyRoom.repository.AdminRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class AdminRepositoryImpl implements AdminRepository {
    private final EntityManager em;

    public AdminRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<String> getEmails() {
        return null;
    }

    @Override
    public Admin getByEmail(String email) {
        return null;
    }

    @Override
    public Admin getById(long id) {
        return null;
    }

    @Override
    public <S extends Admin> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Admin> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Admin> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Admin> findAll() {
        return null;
    }

    @Override
    public Iterable<Admin> findAllById(Iterable<Long> longs) {
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
    public void delete(Admin entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Admin> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
