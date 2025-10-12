package com.example.jsontooldesktop.service;

import com.example.jsontooldesktop.model.JSONDocument;
import com.example.jsontooldesktop.model.User;
import com.example.jsontooldesktop.repository.JSONDocumentRepository;
import com.example.jsontooldesktop.repository.JSONDocumentRepositoryImpl;
import java.util.List;

public class DocumentServiceImpl implements DocumentService {

    private final JSONDocumentRepository documentRepository;

    public DocumentServiceImpl() {
        this.documentRepository = new JSONDocumentRepositoryImpl();
    }

    @Override
    public JSONDocument createDocument(String name, String content, User user) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва документа не може бути порожньою.");
        }
        JSONDocument newDocument = new JSONDocument(name, content, user);
        documentRepository.save(newDocument);

        return newDocument;
    }

    @Override
    public List<JSONDocument> getAllDocuments() {

        return documentRepository.findAll();
    }

    @Override
    public void deleteDocument(JSONDocument document) {
        if (document == null) {
            throw new IllegalArgumentException("Документ для видалення не може бути null.");
        }
        documentRepository.delete(document);
    }
}