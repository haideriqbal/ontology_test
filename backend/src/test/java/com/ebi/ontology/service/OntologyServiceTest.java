package com.ebi.ontology.service;

import com.ebi.ontology.exception.OntologyNotFoundException;
import com.ebi.ontology.model.Ontology;
import com.ebi.ontology.repository.OntologyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class OntologyServiceTest {
    @Autowired
    private OntologyService ontologyService;

    @MockBean
    private OntologyRepository ontologyRepository;

    @Test
    void shouldGetAllOntologyIds() {
        List<String> ids = ontologyService.getAllOntologyIds();
        // Assertions
        assertThat("List should not be empty", !ids.isEmpty());
        assertThat("List should contain EFO", ids.contains("efo"));
        assertThat("List should contain go", ids.contains("go"));
        assertThat("List should contain ncit", ids.contains("ncit"));
        assertThat("List should contain mondo", ids.contains("mondo"));
    }

    @Test
    void shouldGetOntologyByIdWhenExists() {
        Ontology expected = new Ontology();
        when(ontologyRepository.findById("test"))
                .thenReturn(Optional.of(expected));
        Ontology actual = ontologyService.getOntology("test");

        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowNotFoundForInvalidOntologyId() {
        when(ontologyRepository.findById("foo"))
                .thenReturn(Optional.empty());

        assertThrows(OntologyNotFoundException.class,
                () -> ontologyService.getOntology("foo"));
    }
}