package com.ebi.ontology.repository;

import com.ebi.ontology.model.Ontology;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OntologyRepository extends MongoRepository<Ontology, String> {

}
