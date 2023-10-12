import { useState } from 'react';

import OntologyList from './OntologyList';
import OntologyDetails from './OntologyDetails';

function App() {
  const [selectedOntology, setSelectedOntology] = useState(null);

  const handleSelectOntology = (ontologyId) => {
    setSelectedOntology(ontologyId);
    console.log('Selected ontology: ', ontologyId)
  }

  return (
      <div className="container">
        <div className="row">
          <h1>Ontology Browser</h1>
        </div>

        <div className="row">
          <div className="col">
            <h2>Ontologies</h2>
          </div>
          <div className="col">
            <h2>Ontology Details</h2>
          </div>
        </div>
        <div className="row">
          <div className="col scroll border" style={{height: "500px"}}>
          <OntologyList handleSelectOntology={handleSelectOntology} />
          </div>
          <div className="col scroll border" style={{height: "500px"}}>
          {selectedOntology && (
              <OntologyDetails ontologyId={selectedOntology} />
          )}
          </div>
        </div>
      </div>
  );
}

export default App;