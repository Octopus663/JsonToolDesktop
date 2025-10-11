package com.example.jsontooldesktop.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "json_documents")
public class JSONDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime modifiedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public JSONDocument() {}

    public JSONDocument(String name, String content, User user) {
        this.name = name;
        this.content = content;
        this.user = user;
    }

}
