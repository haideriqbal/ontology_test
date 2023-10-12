package com.ebi.ontology.service;

import com.ebi.ontology.exception.OntologyNotFoundException;
import com.ebi.ontology.model.Ontology;
import com.ebi.ontology.repository.OntologyRepository;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OntologyService {
    private final String OLS_API_URL = "https://www.ebi.ac.uk/ols4/api/ontologies";
    private static final Logger logger = LogManager.getLogger(OntologyService.class);

    // Inject repository
    @Autowired
    OntologyRepository ontologyRepository;

    public List<String> getAllOntologyIds() {
        var restTemplate = new RestTemplate();
        var initial_response = restTemplate.getForObject(OLS_API_URL, String.class);

        var totalElements = JsonParser.parseString(initial_response)
                .getAsJsonObject()
                .getAsJsonObject("page")
                .get("totalElements").getAsString();

        var final_response = restTemplate.getForObject(OLS_API_URL + "?size=" + totalElements, String.class);

        return getOntologyIds(final_response);
    }
    public Ontology getOntology(String id) {
        // Call repository method
        logger.info("Checking for ontology in local database");

        return ontologyRepository.findById(id)
                .orElseGet(() -> {
                    logger.info("Ontology not found in local DB, calling OLS API");
                    // Fallback to calling OLS API
                    var restTemplate = new RestTemplate();
                    var ontology = new Ontology();
                    try {
                        var response = restTemplate.getForObject(OLS_API_URL + "/" + id, String.class);
                        ontology = serializeOntologyObject(response);
                    } catch (Exception e) {
                        // Handle case if ontology is not found
                        logger.error("Ontology {} not found in OLS API", id);
                        throw new OntologyNotFoundException(id);
                    }
                    // Save ontology to database
                    logger.info("Saving ontology {} to local DB", id);
                    ontologyRepository.save(ontology);
                    return ontology;
                });
    }

    private Ontology serializeOntologyObject(String data) {
        var jsonObject = JsonParser.parseString(data).getAsJsonObject();
        var ontology = new Ontology();

        ontology.setId(jsonObject.get("ontologyId").getAsString());

        var config = jsonObject.get("config").getAsJsonObject();
        ontology.setTitle(config.get("title").getAsString());

        ontology.setDescription(config.get("description").getAsString());

        List<String> definitions = new ArrayList<>();
        for(JsonElement element : config.get("definitionProperties").getAsJsonArray()) {
            definitions.add(element.getAsString());
        }
        ontology.setDefinitions(definitions);

        List<String> synonyms = new ArrayList<>();
        for(JsonElement element : config.get("synonymProperties").getAsJsonArray()) {
            synonyms.add(element.getAsString());
        }
        ontology.setSynonyms(synonyms);

        return ontology;
    }

    private List<String> getOntologyIds(String data) {
        var json = JsonParser.parseString(data).getAsJsonObject();
        var ontologies = json.getAsJsonObject("_embedded").getAsJsonArray("ontologies");

        List<String> ontologyIds = new ArrayList<>();

        for(JsonElement ontology : ontologies) {
            var ontologyObj = ontology.getAsJsonObject();
            String ontologyId = ontologyObj.get("ontologyId").getAsString();
            ontologyIds.add(ontologyId);
        }
        return ontologyIds;
    }
}
