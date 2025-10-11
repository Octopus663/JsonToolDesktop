package com.example.jsontooldesktop.repository;

import com.example.jsontooldesktop.config.PersistenceManager;
import com.example.jsontooldesktop.model.JSONDocument;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class JSONDocumentRepositoryImpl implements JSONDocumentRepository {

    @Override
    public void save(JSONDocument document) {
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(document); // persist використовується для нових об'єктів
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<JSONDocument> findById(Long id) {
        EntityManager em = PersistenceManager.getEntityManager();
        try {
            JSONDocument document = em.find(JSONDocument.class, id);
            return Optional.ofNullable(document);
        } finally {
            em.close();
        }
    }

    @Override
    public List<JSONDocument> findAll() {
        EntityManager em = PersistenceManager.getEntityManager();
        try {
            // JPQL - це "SQL для об'єктів"
            return em.createQuery("SELECT d FROM JSONDocument d", JSONDocument.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(JSONDocument document) {
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // Перед видаленням об'єкт має бути "керованим" (managed)
            em.remove(em.contains(document) ? document : em.merge(document));
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
