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
          <li><Link to="/"><span>Home</span></Link></li>
          <li><Link to="#"><span>Contacts</span></Link></li>
          <li><Link to="#"><span>Help</span></Link></li>
          <li><Link to="#"><span>About</span></Link></li>
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

const createLinksFull = (props) => {
  if(props.isAuthenticated) {
    return(
      <div id="tools_container">
        <Link to="/" onClick={props.onClickLogOut}>Log out</Link>
      </div>
    );
  } else {
    return(
      <div id="tools_container">
          <Link to="/registration">Registration</Link>
          <Link to="/authentication" onClick={props.onClickLogIn}>Log in</Link>
      </div>
    );
  }
}

const NavigationBar = (props) => {
  return(
    <header id="NavigationBar">
      <div id="nav_bar_small">
        <div id="img"/>
        {createLinks(props)}
      </div>

      <div id="nav_bar_full">
			<div id="nav_container">
				<ul id="nav">
					<li><Link to="/">Home</Link></li>
					<li><Link to="#">Contact</Link></li>
					<li><Link to="#">Help</Link></li>
					<li><Link to="#">About</Link></li>
					<div id="slider"></div>
				</ul>
			</div>
			<div id="logo_container">
				<h1>Logo</h1>
			</div>
			{createLinksFull(props)}
		</div>

    </header>
  );
};

export default NavigationBar;
