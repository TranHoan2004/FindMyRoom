package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Admin;
import com.FindMyRoom.model.User;
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

    @NotNull
    @Override
    public <S extends User> S save(@NotNull S entity) {
        return em.unwrap(Session.class).merge(entity);
    }

    @NotNull
    @Override
    public <S extends User> Iterable<S> saveAll(@NotNull Iterable<S> entities) {
        return null;
    }

    @NotNull
    @Override
    public Optional<User> findById(@NotNull Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(@NotNull Integer integer) {
        return false;
    }

    @NotNull
    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @NotNull
    @Override
    public Iterable<User> findAllById(@NotNull Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(@NotNull Integer integer) {

    }

    @Override
    public void delete(@NotNull User entity) {

    }

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(@NotNull Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<String> getEmails() {
        Session session = em.unwrap(Session.class);
        List<String> emails = session.createQuery("select u.email from User u", String.class).getResultList();
        session.close();
        return emails;
    }

    @Override
    public User getByEmail(String email) {
        Session session = em.unwrap(Session.class);
        User user = session.createQuery("select u from User u where u.email=:email", User.class)
                .setParameter("email", email)
                .getSingleResult();
        session.close();
        return user;
    }
}
