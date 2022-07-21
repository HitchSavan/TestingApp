import React, { Component } from 'react';
import { Switch, Route, Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

import AuthService from './services/auth.service';

import Login from './components/login.component';
import Register from './components/register.component';
import Home from './components/home.component';
import Test from './components/createTest.component';
import Users from './components/users.component';
import Questions from './components/questions.component';
import Profile from './components/profile.component';

class App extends Component {
    constructor(props) {
        super(props);
        this.logOut = this.logOut.bind(this);

        this.state = {
            currentUser: undefined,
        };
    }

    componentDidMount() {
        const user = AuthService.getCurrentUser();

        if (user) {
            this.setState({
                currentUser: user,
            });
        }
    }

    logOut() {
        AuthService.logout();
    }

    render() {
        const { currentUser } = this.state;

        return (
            <div>
                <nav className="navbar navbar-expand-sm navbar-dark bg-dark logo">
                    <Link to={"/"} className="navbar-brand">
                        TestApp
                    </Link>
                    <div className="navbar-nav me-auto">
                        <li className="nav-item">
                            <Link to={"/home"} className="nav-link">
                                Home
                            </Link>
                        </li>
                        {currentUser && (
                            <li className="nav-item dropdown">
                                <a className="nav-link dropdown" href="#" id="navbarDropdown" aria-expanded="false">
                                    Data
                                </a>
                                <ul class="list-inline dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="nav-link dropdown-item" href="/test">Test</a></li>
                                    <li><a class="nav-link dropdown-item" href="/users">Users</a></li>
                                    <li><a class="nav-link dropdown-item" href="/questions">Questions</a></li>
                                </ul>
                            </li>
                        )}
                        
                        {currentUser && (
                            <div className="navbar-nav">
                                <li className="nav-item">
                                    <Link to={"/profile"} className="nav-link">
                                        {currentUser.username}'s Profile
                                    </Link>
                                </li>
                            </div>
                        )}

                    </div>
                    {currentUser ? (
                        <div className="navbar-nav navbar-right">
                            <li className="nav-item">
                                <a href="/login" className="nav-link" onClick={this.logOut}>
                                    LogOut
                                </a>
                            </li>
                        </div>
                        
                    ) : (
                        <div className="navbar-nav">
                            <li className="nav-item">
                                <Link to="/login" className="nav-link">
                                    Login
                                </Link>
                            </li>

                            <li className="nav-item">
                                <Link to={"/register"} className="nav-link">
                                    Sign Up
                                </Link>
                            </li>
                        </div>
                    )}
                </nav>

                <div className="container-mt3">
                    <Switch>
                        <Route exact path={["/", "/home"]} component={Home} />
                        <Route exact path="/login" component={Login} />
                        <Route exact path="/register" component={Register} />
                        <Route exact path="/profile" component={Profile} />
                        <Route exect path="/test" component={Test}/>
                        <Route exect path="/users" component={Users}/>
                        <Route exect path="/questions" component={Questions}/>
                    </Switch>
                </div>
            </div>
        );
    }
}

export default App;
