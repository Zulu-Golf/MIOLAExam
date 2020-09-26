


import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import Can from "../components/Can";
import {AuthConsumer} from "../authContext";

import { Redirect } from "react-router-dom";
const Enseignant = () => {
  const [users, setUser] = useState([]);

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:4001/professeurs");
    setUser(result.data.reverse());
  };

  const deleteUser = async id => {
    await axios.delete(`http://localhost:3003/etudiant/${id}`);
    loadUsers();
  };

  return (
    <AuthConsumer>
    {({ user }) => (
      <Can
        role={user.role}
        perform="dashboard-page:visit"
        yes={() => (
          <div className="container">
          <div className="py-4">
            <h2>Enseignant</h2>
            <table class="table border shadow">
              <thead class="thead-dark">
                <tr>
                  <th scope="col">Nom</th>
                  <th scope="col">Prenom </th>
                  <th scope="col"> Age </th>
                  
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
                {users.map((user, index) => (
                  <tr>
                    <td>{user.nom}</td>
                    <td>{user.prenom}</td>
                    <td>{user.age}</td>
                    
                    <td>
                      <Link class="btn btn-primary mr-2" to={`/users/${user.id}`}>
                        View
                      </Link>
                      <Link
                        class="btn btn-outline-primary mr-2"
                        to={`/etudian/edit/${user.id}`}
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
        )}
        no={() => <Redirect to="/" />}
      />
    )}
  </AuthConsumer>
    
  );
};




export default Enseignant ;
