package com.example.jsontooldesktop.repository;

import com.example.jsontooldesktop.model.Template;
import java.util.List;
import java.util.Optional;

public interface TemplateRepository {
    void save(Template template);
    Optional<Template> findById(Long id);
    List<Template> findAll();
    void delete(Template template);
}