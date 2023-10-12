package com.ebi.ontology.controller;

import com.ebi.ontology.exception.OntologyNotFoundException;
import com.ebi.ontology.model.Ontology;
import com.ebi.ontology.service.OntologyService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OntologyController.class)
public class OntologyControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OntologyService ontologyService;

    @MockBean
    private Gson gson;

    @Test
    void shouldGetAllOntologyIds() throws Exception {
        List<String> ids = Arrays.asList("id1", "id2");
        when(ontologyService.getAllOntologyIds())
                .thenReturn(ids);

        String responseJson = "[\"id1\",\"id2\"]";
        when(gson.toJson(ids))
                .thenReturn(responseJson);

        mvc.perform(get("/api/ontologies"))
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson));
    }

    @Test
    void shouldGetOntologyById() throws Exception {
        Ontology ontology = new Ontology("test", "Test Ontology",
                "Test description", new ArrayList<>(), new ArrayList<>());
        when(ontologyService.getOntology("test"))
                .thenReturn(ontology);

        String json = "{\"id\":\"test\",\"name\":\"Test Ontology\",\"description\":\"Test description\"}";
        when(gson.toJson(ontology))
                .thenReturn(json);

        mvc.perform(get("/api/ontologies/test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("test"));
    }
/*
    @Test
    void shouldHandleNotFoundException() throws Exception {
        when(ontologyService.getOntology("invalid"))
                .thenThrow(new OntologyNotFoundException("invalid"));

        mvc.perform(get("/api/ontologies/invalid"))
                .andExpect(status().isInternalServerError());
    }*/
}