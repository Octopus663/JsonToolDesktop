package com.example.jsontooldesktop.service;

import com.example.jsontooldesktop.model.Template;
import com.example.jsontooldesktop.model.User;
import com.example.jsontooldesktop.repository.TemplateRepository;
import com.example.jsontooldesktop.repository.TemplateRepositoryImpl;
import java.util.List;

public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository templateRepository;

    public TemplateServiceImpl() {
        this.templateRepository = new TemplateRepositoryImpl();
    }

    @Override
    public Template createTemplate(String name, String schemaContent, User createdBy) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва шаблону не може бути порожньою.");
        }
        Template newTemplate = new Template(name, schemaContent, createdBy);
        templateRepository.save(newTemplate);
        return newTemplate;
    }

    @Override
    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }

    @Override
    public void deleteTemplate(Template template) {
        if (template == null) {
            throw new IllegalArgumentException("Шаблон для видалення не може бути null.");
        }
        templateRepository.delete(template);
    }
}