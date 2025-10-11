package com.example.jsontooldesktop.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "templates")
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String schemaContent;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    public Template() {}

    public Template(String name, String schemaContent, User createdBy) {
        this.name = name;
        this.schemaContent = schemaContent;
        this.createdBy = createdBy;
    }

    // геттери/сеттери
}
