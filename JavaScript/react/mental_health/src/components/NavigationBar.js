import React from 'react';
import {Link} from 'react-router-dom';
import './../css/navigationBar.css';

const NavigationBar = (props) => {
  return(
    <header id="NavigationBar">
      <div id="img"/>
      <div id="list">
        <ul>
          <li><Link to="/">Welcome</Link></li>
          <li><Link to="/registration">Registration</Link></li>
          <li><Link to="/authentication">Authentication</Link></li>
          <li><Link to="/"
                    onClick={props.onClickLogOutOrIn}>
                {props.isAuthenticated ? "Log out" : "Log in"}
              </Link></li>
        </ul>
      </div>
    </header>
  );
};

export default NavigationBar;
