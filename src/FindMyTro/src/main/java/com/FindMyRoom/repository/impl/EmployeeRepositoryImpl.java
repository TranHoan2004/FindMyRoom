package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Employee;
import com.FindMyRoom.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EntityManager em;

    public EmployeeRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @NotNull
    public <S extends Employee> S save(@NotNull S entity) {
        return null;
    }

    @Override
    @NotNull
    public <S extends Employee> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @Override
    @NotNull
    public Optional<Employee> findById(@NotNull Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Long aLong) {
        return false;
    }

    @Override
    @NotNull
    public Iterable<Employee> findAll() {
        return null;
    }

    @Override
    @NotNull
    public Iterable<Employee> findAllById(@NotNull Iterable<Long> longs) {
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
    public void delete(@NotNull Employee entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends Employee> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
