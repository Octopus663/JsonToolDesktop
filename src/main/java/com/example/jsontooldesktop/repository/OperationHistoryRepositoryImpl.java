package com.example.jsontooldesktop.repository;

import com.example.jsontooldesktop.config.PersistenceManager;
import com.example.jsontooldesktop.model.OperationHistory;
import com.example.jsontooldesktop.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class OperationHistoryRepositoryImpl implements OperationHistoryRepository {

    @Override
    public void save(OperationHistory history) {
        EntityManager em = PersistenceManager.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(history);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<OperationHistory> findByUser(User user) {
        EntityManager em = PersistenceManager.getEntityManager();
        try {
            return em.createQuery("SELECT h FROM OperationHistory h WHERE h.user = :user", OperationHistory.class)
                    .setParameter("user", user)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}