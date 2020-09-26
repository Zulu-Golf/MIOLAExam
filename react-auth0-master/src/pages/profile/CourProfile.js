
import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const Cours = (props) => {
  const [users, setUser] = useState([]);

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get(`http://localhost:4001/courses/${props.Id}`).then(console.log(result=>result.data));
    setUser(result.data.reverse());
  };

  const deleteUser = async id => {
    await axios.delete(`http://localhost:4001/courses/${id}`);
    loadUsers();
  };

  return (
    <div className="container">
      <div className="py-4">
        <h2>Cours</h2>
        <table class="table border shadow">
          <thead class="thead-dark">
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Nom </th>
              <th scope="col"> Professeur </th>
              
              <th >Action</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user, index) => (
              <tr>
                
                <td>{user.id}</td>
                <td>{user.nom}</td>
                <td>{user.professeur.nom}</td>
                
                <td>
                  <Link class="btn btn-primary mr-2" to={`/cours/${user.id}`}>
                    View
                  </Link>
                  <Link
                    class="btn btn-outline-primary mr-2"
                    to={`/cours/edit/${user.id}`}
                  >
                    Edit
                  </Link>
                  <Link
                    class="btn btn-danger"
                    onClick={() => deleteUser(user.id)}
                  >
                    Delete
                  </Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Cours;
