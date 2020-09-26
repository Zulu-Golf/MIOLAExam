import React,{Component} from 'react';
import { Nav, Navbar, NavbarBrand, NavbarToggler, Collapse, NavItem, Jumbotron } from 'reactstrap';
import Login from "../components/Login";
import Logout from "../components/Logout";
import { AuthConsumer } from "../authContext";
import {NavLink} from 'react-router-dom';
class Header extends Component{
    constructor(props){
        super(props);
        this.toggleNav=this.toggleNav.bind(this);
        this.state= {
            isNaveOpen: false
        };  
        
    }
    toggleNav(){
        this.setState({
            isNavOpen: !this.state.isNavOpen
        });
    }
    render(){
        return(
            <div>
                
                <Navbar dark expand="md">
                    <div className="container">
                        <NavbarToggler onClick={this.toggleNav}/>
                        <NavbarBrand className="mr-auto" href="/home">
                            <img src="assets/images/logo.png" height="30" width="41" alt="MIOLA Exam "/>
                        </NavbarBrand>
                        <Collapse isOpen={this.state.isNavOpen} navbar>
                            <Nav navbar>
                                <NavItem>
                                    <NavLink className="nav-link"  to='/home'><span className="fa fa-home fa-lg"></span> Acceuil</NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink className="nav-link" to='/aboutus'><span className="fa fa-info fa-lg"></span> Sur nous</NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink className="nav-link"  to='/menu'><span className="fa fa-list fa-lg"></span> Menu</NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink className="nav-link" to='/contactus'><span className="fa fa-address-card fa-lg"></span> Contactez nous</NavLink>
                                </NavItem>
                            </Nav>
                        </Collapse>
                        <AuthConsumer>
                        {({authenticated})=>authenticated?(                        
                        <Logout/>):(                        
                        <Login/>
                        )}
                        </AuthConsumer>

                    </div>
                </Navbar>
            <Jumbotron fluid >
                <div className="container">
                    <div className="row row-header">
                        <div className="col-12 col-sm-6">
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
            
            </div>
        );
    }
}
export default Header;