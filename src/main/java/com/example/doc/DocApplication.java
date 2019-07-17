package com.example.doc;

import com.example.doc.domin.Document;
import com.example.doc.domin.Keyword;
import com.example.doc.service.DocumentService;
import com.example.doc.service.KeywordService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class DocApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(DocumentService documentService, KeywordService keywordService) {
        return args -> {
            Keyword it = new Keyword("IT");
            Keyword electronic = new Keyword("Electronic");
            Keyword computer = new Keyword("Computer");

            keywordService.save(it);
            keywordService.save(electronic);
            keywordService.save(computer);

            Set<Keyword> keyList1 = Set.of(it, electronic);
            Set<Keyword> keyList2 = Set.of(it, computer);
            Set<Keyword> keyList3 = Set.of(it, computer, electronic);

            documentService.save(new Document("doc 1", keyList1));
            documentService.save(new Document("doc 2", keyList2));
            documentService.save(new Document("doc 3", keyList3));

        };
    }

}
