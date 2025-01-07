package com.FindMyRoom.repository.impl;

import com.FindMyRoom.model.Admin;
import com.FindMyRoom.model.User;
import com.FindMyRoom.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
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
    public <S extends Admin> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Admin> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Admin> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Admin> findAll() {
        return null;
    }

    @Override
    public Iterable<Admin> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Admin entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Admin> entities) {

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
