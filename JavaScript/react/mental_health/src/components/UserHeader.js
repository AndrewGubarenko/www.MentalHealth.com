import React from 'react';
import {connect} from 'react-redux';

const createEditButton = (props) => {
  if(props.isAuthenticated) {
    return(
      <div id="buttonContainer" style={{'--buttonFloat': 'right'}}>
        <div id="button" style={{'--buttonColor': '#02364c'}}>
          <div id="inscription">Edit Profile</div>
          <div id="bottom-border"></div>
          <div id="right-border"></div>
        </div>
      </div>
    );
  }
}

class UserData extends React.Component {
  render() {
    return(
      <div id="person_container">
        <div id="cover">
          <div id="name">
            <label type="text">{this.props.name}</label> <label type="text">{this.props.surname}</label>
          </div>
        </div>
        {createEditButton(this.props)}
        <div id="photoContainerView">
          <img id="userPhotoView" alt="" />
        </div>
        <div id="speciality">
          <label type="text">{this.props.speciality}</label>
        </div>
        <div id="location">
          <label type="text">{this.props.location}</label>
        </div>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  let props = {
    isAuthenticated: state.server.user.isAuthenticated
  };
  return props;
};

//function
let reduxContainerCreator = connect(mapStateToProps);
//React component class
let ReduxUserData = reduxContainerCreator(UserData);

export default ReduxUserData;
