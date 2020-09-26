
import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import Can from "../components/Can";
import {AuthConsumer} from "../authContext";

import { Redirect } from "react-router-dom";
const Examens = () => {
  const [users, setUser] = useState([]);

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
     const result= await axios.get("http://localhost:4001/examens");
    setUser(result.data.reverse());
  };

  const deleteUser = async id => {
    await axios.delete(`http://localhost:4001/examens/${id}`);
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
      <h2>Examen</h2>
      <table class="table border shadow">
        <thead class="thead-dark">
          <tr>
            <th scope="col">Examens</th>
            <th scope="col">Enseignant </th>
            <th scope="col"> Date </th>
            <th scope="col">Durée</th>
            <th scope="col">Salle</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user, index) => (
            <tr>
              <td>XML</td>
              <td>{user.cours.professeur.nom}</td>
              <td>{user.dateExam}</td>
              <td>10</td>
              <td>12</td>
              <td>
                <Link class="btn btn-primary mr-2" to={`/examens/${user.id}`}>
                  View
                </Link>
                <Link
                  class="btn btn-outline-primary mr-2"
                  to={`/examens/edit/${user.id}`}
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

export default Examens;
