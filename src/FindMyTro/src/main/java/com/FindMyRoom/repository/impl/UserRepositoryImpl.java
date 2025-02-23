package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Users;
import com.FindMyRoom.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserRepositoryImpl implements UserRepository {
    private final EntityManager em;

    public UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<String> getEmails() {
        Session session = em.unwrap(Session.class);
        List<String> emails = session.createQuery("select u.email from Users u", String.class).getResultList();
        session.close();
        return emails;
    }

    @Override
    public Users getByEmail(String email) {
        List<Users> list = em.createQuery("SELECT u FROM Users u WHERE u.email=:email", Users.class)
                .setParameter("email", email)
                .getResultList();
        return list.isEmpty() ? null : list.getFirst();
    }

    @Override
    @NotNull
    public <S extends Users> S save(@NotNull S entity) {
        return null;
    }

    @Override
    @NotNull
    public <S extends Users> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @Override
    @NotNull
    public Optional<Users> findById(@NotNull Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Long aLong) {
        return false;
    }

    @Override
    @NotNull
    public Iterable<Users> findAll() {
        return null;
    }

    @NotNull
    @Override
    public Iterable<Users> findAllById(@NotNull Iterable<Long> longs) {
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
    public void delete(@NotNull Users entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends Users> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
