package com.ebi.ontology.exception;

import org.springframework.stereotype.Component;

public class OntologyNotFoundException extends RuntimeException {
    public OntologyNotFoundException(String id) {
        super("Could not find ontology " + id);
    }
}