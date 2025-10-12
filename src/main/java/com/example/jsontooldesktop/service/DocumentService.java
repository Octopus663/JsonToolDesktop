package com.example.jsontooldesktop.service;

import com.example.jsontooldesktop.model.JSONDocument;
import com.example.jsontooldesktop.model.User;
import java.util.List;

public interface DocumentService {

    JSONDocument createDocument(String name, String content, User user);
    List<JSONDocument> getAllDocuments();
    void deleteDocument(JSONDocument document);
}