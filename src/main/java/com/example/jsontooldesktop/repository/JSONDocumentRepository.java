package com.example.jsontooldesktop.repository;

import com.example.jsontooldesktop.model.JSONDocument;
import java.util.List;
import java.util.Optional;

public interface JSONDocumentRepository {

    void save(JSONDocument document);

    Optional<JSONDocument> findById(Long id);

    List<JSONDocument> findAll();

    void delete(JSONDocument document);
}
