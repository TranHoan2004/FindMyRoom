package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Employee;
import com.FindMyRoom.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Autowired
    private final EntityManager em;

    public EmployeeRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public long count() {
        return 0;
    }

    @NotNull
    @Override
    public <S extends Employee> S save(@NotNull S entity) {
        return null;
    }

    @NotNull
    @Override
    public <S extends Employee> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @NotNull
    @Override
    public Optional<Employee> findById(@NotNull Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Integer integer) {
        return false;
    }

    @NotNull
    @Override
    public Iterable<Employee> findAll() {
        return em.unwrap(Session.class)
                .createQuery("from Employee", Employee.class)
                .list();
    }

    @NotNull
    @Override
    public Iterable<Employee> findAllById(@NotNull Iterable<Integer> integers) {
        return null;
    }

    @Override
    public void deleteById(@NotNull Integer integer) {

    }

    @Override
    public void delete(@NotNull Employee entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
