package com.example.jsontooldesktop.repository;

import com.example.jsontooldesktop.model.OperationHistory;
import com.example.jsontooldesktop.model.User;
import java.util.List;

public interface OperationHistoryRepository {
    void save(OperationHistory history);
    List<OperationHistory> findByUser(User user);
}