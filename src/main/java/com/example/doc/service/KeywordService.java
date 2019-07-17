package com.example.doc.service;

import com.example.doc.domin.Keyword;
import com.example.doc.repository.KeywordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KeywordService {

    private final KeywordRepository keywordRepository;

    public KeywordService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    public void save(Keyword keyword) {
        keywordRepository.save(keyword);
    }
}
