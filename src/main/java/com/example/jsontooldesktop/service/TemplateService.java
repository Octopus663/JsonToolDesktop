package com.example.jsontooldesktop.service;

import com.example.jsontooldesktop.model.Template;
import com.example.jsontooldesktop.model.User;
import java.util.List;

public interface TemplateService {
    Template createTemplate(String name, String schemaContent, User createdBy);
    List<Template> getAllTemplates();
    void deleteTemplate(Template template);
}