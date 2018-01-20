import React from 'react';
import {Link} from 'react-router-dom';
import './../css/navigationBar.css';

const createLinks = (props) => {
  if(props.isAuthenticated) {
    return(
      <div id="list">
        <ul>
          <li><Link to="/"><span>Welcome</span></Link></li>
          <li><Link to="/"
                    onClick={props.onClickLogOut}>
                <span>Log out</span>
              </Link>
          </li>
        </ul>
      </div>
    );
  } else {
    return(
      <div id="list">
        <ul>
          <li><Link to="/"><span>Welcome</span></Link></li>
          <li><Link to="/registration"><span>Registration</span></Link></li>
          <li><Link to="/authentication"
                    onClick={props.onClickLogIn}>
                <span>Log in</span>
              </Link>
          </li>
        </ul>
      </div>
    );
  }
}

const NavigationBar = (props) => {
  return(
    <header id="NavigationBar">
      <div id="img"/>
      {createLinks(props)}
    </header>
  );
};

export default NavigationBar;
