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

}