import React from 'react';
import './../css/footer.css';
import {Link} from 'react-router-dom';

export default class Footer extends React.Component {
  render(){
    return(
      <footer className="Footer">
        <div id="first_level_footer">
          <div id="logo_footer_container">
            <h1>Logo</h1>
          </div>
          <div className="first_level_footer_container">
            <Link to="#">About this site</Link>
            <Link to="#">About owner</Link>
            <Link to="#">Developers</Link>
            <Link to="#">Link #</Link>
          </div>
          <div className="first_level_footer_container">
            <Link to="#">Link 1</Link>
            <Link to="#">Link 2</Link>
            <Link to="#">Link 3</Link>
            <Link to="#">Link 4</Link>
          </div>
        </div>
        <div id="second_level_footer">
          <Link to="#">Terms & Condition</Link>
          <Link to="#">Privacy Policy</Link>
        </div>
        <p><b>&copy; {new Date().getFullYear()} www.MentalHealth.com/All Rights Reserved</b></p>
      </footer>
    )
  }
}
