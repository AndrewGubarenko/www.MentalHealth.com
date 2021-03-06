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
            <div className="link_footer_container">
              <span to="#">About this site</span>
              <span to="#">About owner</span>
              <span to="#">Developer</span>
            </div>
            <div className="link_footer_container">
              <Link to="#">Link to "About this site"</Link>
              <Link to="#">Link to "About owner"</Link>
              <Link to="https://www.linkedin.com/in/andrii-hubarenko-1a2988116/">Anddrii Hubarenko</Link>
            </div>
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
