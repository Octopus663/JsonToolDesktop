package com.example.jsontooldesktop.repository;

import com.example.jsontooldesktop.config.PersistenceManager;
import com.example.jsontooldesktop.model.Template;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class TemplateRepositoryImpl implements TemplateRepository {

    @Override
    public void save(Template template) {
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(template);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<Template> findById(Long id) {
        EntityManager em = PersistenceManager.getEntityManager();
        try {
            return Optional.ofNullable(em.find(Template.class, id));
        } finally {
            em.close();
        }
    }

    @Override
    public List<Template> findAll() {
        EntityManager em = PersistenceManager.getEntityManager();
        try {
            return em.createQuery("SELECT t FROM Template t", Template.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Template template) {
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.contains(template) ? template : em.merge(template));
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}