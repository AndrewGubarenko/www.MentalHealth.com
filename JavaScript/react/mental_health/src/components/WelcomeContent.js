import React from 'react'
import {Link} from 'react-router-dom'

export default class WelcomeContent extends React.Component {
  render() {
    return(
      <div className="Container">
        <div className="WelcomeContent">
          <h1>Welcome to Mental Health page</h1>
          <p>
            Here is a Mental Health website for psychological spesialists. Some other description.
          <br/>
          <Link to="/registration">Sign up </Link>or
          <Link to="/authentication"> Sign in</Link>
          </p>
        </div>
      </div>
    )
  }
}
