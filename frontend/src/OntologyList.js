import { useState, useEffect } from 'react';
import axios from 'axios';
import {List} from 'react-virtualized';
import './App.css';

import OntologyListItem from './OntologyListItem';

function OntologyList({handleSelectOntology}) {
    const [ontologies, setOntologies] = useState([]);

    useEffect(() => {
        const fetchOntologies = async () => {
            const result = await axios.get('http://localhost:8080/api/ontologies');

            setOntologies(result.data);
        };

        fetchOntologies();
    }, []);

    const listItems = ontologies.map((ontology) =>
        <li key={ontology}>
            <OntologyListItem
                ontology={ontology}
                onSelect={handleSelectOntology}
            />
        </li>
    );

    return (
        <ul>{listItems}</ul>
    );
}

export default OntologyList;