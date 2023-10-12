function OntologyListItem({ ontology, onSelect }) {

    return (
        <div onClick={() => onSelect(ontology)}>
            {ontology}
        </div>
    );
}

export default OntologyListItem;