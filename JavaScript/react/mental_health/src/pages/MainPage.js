import React from 'react';
import './../css/MainPage.css'
import './../css/userListRepresentation.css'
import WelcomeContent from './../components/WelcomeContent'
import UserPlateRepresentationListContainer from './../containers/UserPlateRepresentationListContainer';

export default class MainPage extends React.Component {
  render() {
    return(
      <div>
        <div id="welcome_content_container">
          <WelcomeContent />
          <div id="arrow_container">
            <span id="arrow_inscription">Explore the site</span>
            <span id="arrow" />
          </div>
        </div>
        <div id="user_plates_container">
          <h1>Our Specialists</h1>
          <UserPlateRepresentationListContainer />
        </div>
        <div id="articles">

        </div>
      </div>
    );
  }
}
