package com.ebi.ontology.controller;

import com.ebi.ontology.service.OntologyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// This annotation was adddd to handle CORS issues when running the frontend and backend on different ports locally
// This can be removed when deploying the frontend and backend on the same domain
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/ontologies")
public class OntologyController {
    private static final Logger logger = LogManager.getLogger(OntologyController.class);

    @Autowired
    OntologyService ontologyService;

    @Autowired
    private Gson gson;

    @GetMapping
    public String getAllOntologyIds() {
        return gson.toJson(ontologyService.getAllOntologyIds());
    }

    @GetMapping("/{ontologyId}")
    public String getOntology(@PathVariable String ontologyId) {
        // get ontology by ID
        logger.info("Retrieving ontology {}", ontologyId);
        return gson.toJson(ontologyService.getOntology(ontologyId));
    }
}
