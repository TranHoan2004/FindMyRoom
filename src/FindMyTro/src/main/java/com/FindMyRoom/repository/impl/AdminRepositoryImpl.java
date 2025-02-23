package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Admin;
import com.FindMyRoom.repository.AdminRepository;
import jakarta.persistence.EntityManager;
import org.jetbrains.annotations.NotNull;
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
        return List.of();
    }

    @Override
    public Admin getByEmail(String email) {
        return null;
    }

    @Override
    public Admin getById(long id) {
        return null;
    }

    @NotNull
    @Override
    public <S extends Admin> S save(@NotNull S entity) {
        return null;
    }

    @NotNull
    @Override
    public <S extends Admin> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @NotNull
    @Override
    public Optional<Admin> findById(@NotNull Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Long id) {
        return false;
    }

    @NotNull
    @Override
    public Iterable<Admin> findAll() {
        return null;
    }

    @NotNull
    @Override
    public Iterable<Admin> findAllById(@NotNull Iterable<Long> id) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(@NotNull Long id) {

    }

    @Override
    public void delete(@NotNull Admin entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Long> id) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends Admin> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
