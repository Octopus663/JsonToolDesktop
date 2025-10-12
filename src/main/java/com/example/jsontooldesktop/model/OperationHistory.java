package com.example.jsontooldesktop.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "operation_history")
public class OperationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operationType;

    private LocalDateTime executedAt = LocalDateTime.now();

    @Lob
    private String result;

    // Зв'язки
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private JSONDocument document;

    public OperationHistory() {}

    public OperationHistory(String operationType, String result, User user, JSONDocument document) {
        this.operationType = operationType;
        this.result = result;
        this.user = user;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public LocalDateTime getExecutedAt() {
        return executedAt;
    }

    public void setExecutedAt(LocalDateTime executedAt) {
        this.executedAt = executedAt;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JSONDocument getDocument() {
        return document;
    }

    public void setDocument(JSONDocument document) {
        this.document = document;
    }
}