
import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import Can from "../components/Can";
import {AuthConsumer} from "../authContext";

import { Redirect } from "react-router-dom";
const Salles = () => {
  const [users, setUser] = useState([]);

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:4001/salles");
    setUser(result.data.reverse());
  };

  const deleteUser = async id => {
    await axios.delete(`http://localhost:4001/salles/${id}`);
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
              <h2>Salles</h2>
              <table class="table border shadow">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Nom </th>
                    <th scope="col"> Nombre de places </th>
                    
                    <th >Action</th>
                  </tr>
                </thead>
                <tbody>
                  {users.map((user, index) => (
                    <tr>
                      
                      <td>{user.id}</td>
                      <td>{user.nom}</td>
                      <td>{user.nbPlaces}</td>
                      
                      <td>
                        <Link class="btn btn-primary mr-2" to={`/salles/${user.id}`}>
                          View
                        </Link>
                        <Link
                          class="btn btn-outline-primary mr-2"
                          to={`/salles/edit/${user.id}`}
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

export default Salles;
