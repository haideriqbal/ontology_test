package com.ebi.ontology.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.List;

public class Ontology {

    @Id
    private String id;
    private String title;
    private String description;
    private List<String> definitions;
    private List<String> synonyms;

    public Ontology() {}

    public Ontology(String id, String title, String description, List<String> definitions, List<String> synonyms) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.definitions = definitions;
        this.synonyms = synonyms;
    }

    public String getId() {
        return id;
    }

    public List<String> getDefinitions() {
        return definitions;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ontology{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", definitions=" + definitions +
                ", synonyms=" + synonyms +
                '}';
    }
}