package com.example.doc.service;

import com.example.doc.domin.Document;
import com.example.doc.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public void save(Document document) {
        documentRepository.save(document);
    }
}
