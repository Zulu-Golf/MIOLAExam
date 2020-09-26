import React from 'react';
import './App.css';
import Header from "./components/Header";

import HomePage from './components/Home';
import DashboardPage from './components/dashboard';
import CallbackPage from "./components/Callback";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Examens from './pages/Examens';
import Enseignant from './pages/Enseignant';
import Etudiants from './pages/Etudiants';
import Salles from "./pages/Salles";
import Cours from "./pages/Cours";
import CourProfile from "./pages/profile/CourProfile"
import Home from "./components/Home";

import Navbar from './components/Navbar';


function App() {
 

  return (
    <div>
       
        <Router>
        
        <Navbar/>
          <Switch>
            <Route exact path="/" component={HomePage}/>
            <Route exact path="/home" component={HomePage}/>
            <Route path="/dashboard" component={DashboardPage}/>
            <Route path="/callback" component={CallbackPage}/>
            <Route path='/' exact component={Home} />
            <Route path='/examens' component={Examens} />
            <Route path='/enseignant' component={Enseignant} />
            <Route path='/etudiant' component={Etudiants} />
           

            <Route path='/salle' component={Salles} />
            <Route path='/cour' component={Cours} />
            <Route path='/cour/:Id' component={() => <CourProfile Id={':Id'} />} />

          </Switch>
        </Router>
      
    
      
    </div>
  );
}

export default App;
