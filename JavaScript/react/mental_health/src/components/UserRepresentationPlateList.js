import React from 'react';
import UserRepresentationPlate from './UserRepresentationPlate';

export default class UserRepresentationPlateList extends React.Component {

  createUserRepresentationPlate(userPlateById) {
    let result = [];
    Object.values(userPlateById).forEach(userPlateById => {
      console.log(userPlateById);
      result.push(
        <UserRepresentationPlate
          {...this.props}
        />
      );
    });
    return result;
  }

  render() {
    return(
      <div>
        {this.createUserRepresentationPlate(this.props.userPlateById)}
      </div>
    );
  }
}
