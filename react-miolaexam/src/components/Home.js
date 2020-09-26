import React from "react";
import { Redirect } from "react-router-dom";

import { AuthConsumer } from "../authContext";
import {Jumbotron} from "reactstrap";


const HomePage = () => (
  <AuthConsumer>
    {({ authenticated }) =>
      authenticated ? (
        <Redirect to="/dashboard" />
      ) : (
        <>
        
        <Jumbotron>
        <div className="container">
            <div className="row row-header">
                <div className="col-12 ">
                <h1>
                    Bienvenu à MIOLA Exam
                </h1>
                <p>
                   L'information au bout des doits...<br/>
                   Examen, Rattrappages, notes...
                </p>
                </div>
            </div>
        </div>
    </Jumbotron>
           
       </>
      )
    }
  </AuthConsumer>
);

export default HomePage;