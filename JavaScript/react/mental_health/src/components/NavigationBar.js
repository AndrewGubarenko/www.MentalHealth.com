import React from 'react'
import {Link} from 'react-router-dom'

export default class NavigationBar extends React.Component {
  render() {
    return(
      <header id="NavigationBar">
        <div id="img"/>
        <div id="list">
          <ul>
            <li><Link to="/">Welcome</Link></li>
            <li><Link to="/registration">Registration</Link></li>
            <li><Link to="/authentication">Authentication</Link></li>
            <li><Link to="/">Log Out</Link></li>
          </ul>
        </div>
      </header>
    )
  }
}
