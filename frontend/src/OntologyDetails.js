import { useState, useEffect } from 'react';
import axios from 'axios';

function OntologyDetails({ ontologyId }) {
    const [ontology, setOntology] = useState(null);

    useEffect(() => {
        const fetchOntology = async () => {
            const result = await axios.get('http://localhost:8080/api/ontologies/' + ontologyId);
            setOntology(result.data);
        };
        fetchOntology();
    }, [ontologyId]);

    return (
        <div className='row'>
            {ontology && (
                <div>
                    <h1>{ontology.id}</h1>
                    <h2>{ontology.title}</h2>
                    <p>{ontology.description}</p>
                    <h3>Definitions</h3>
                    <ul>
                        {ontology.definitions.map(def => (
                            <li key={def}>{def}</li>
                        ))}
                    </ul>
                    <h3>Synonyms</h3>
                    <ul>
                        {ontology.synonyms.map(syn => (
                            <li key={syn}>{syn}</li>
                        ))}
                    </ul>
                </div>
            )}
        </div>
    );
}

export default OntologyDetails;