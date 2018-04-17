import React from 'react';
import './../css/UserViewProfile.css';
import './../css/button.css';

import UserDataContainer from './../containers/UserDataContainer';

export default class UserViewProfile extends React.Component {

  render() {
    return(
      <div id="data_container">
        <UserDataContainer
          id={this.props.match.params.id}
          history={this.props.history}
          parentId={this.props.match.params.parentId}
        />
        <div className="line"/>
      </div>
    );
  }
}
