package com.example.doc.domin;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "doc_keywords",
            joinColumns = @JoinColumn(name = "doc_id"),
            inverseJoinColumns = @JoinColumn(name = "key_id")
    )
    private Set<Keyword> keywords;

    public Document() {
        // recommend by hibernate
    }

    public Document(String name, Set<Keyword> keywords) {
        this.name = name;
        this.keywords = keywords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
