import React from 'react';
import Table from 'react-bootstrap/Table'

function Home() {
  return (
   



      <div class="container exames">
<div className="py-4">
  <h1> Examen En Cours</h1>
      <Table striped bordered hover>

        
        <thead>
    <tr>
      
      <th class="center">Examen</th>
      <th class="center">Enseignant</th>
      <th class="center">Date</th>
      <th class="center">Durée</th>
      <th class="center">Salle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      
    <td class="center">Data-Mining</td>
      <td class="center">Ali Idri </td>
      <td class="center">25-Junuary 2020</td>
      <td class="center">3h</td>
      <td class="center">A6</td>
    </tr>
   
   
  </tbody>
</Table>
</div>


</div>


   
  );
}

export default Home;
