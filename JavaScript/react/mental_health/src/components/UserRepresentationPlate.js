import React from 'react';

export default class UserRepresentationPlate extends React.Component {
  render() {

    return(

      <div id="user_representation_container">
        <div id="user_photo_min_container">
          <img id="user_photo_min" alt="" />
        </div>

        <div id="user_rating_container">
          <ul className="commentRating">
            <li id="stars" style={{width: (this.props.rating/5*100) + "%"}} />
          </ul>
        </div>

        <div id="user_data_container">
          <label className="data_row" id="data_row_name" type="text">{this.props.name} {this.props.surname}</label>
          <label className="data_row" type="text">{this.props.speciality}</label>
          <label className="data_row" type="text">{this.props.location}</label>
          <label className="data_row" type="text">{this.props.price} {this.props.currency}</label>
          <label className="data_row" type="text">{this.props.experience}</label>
        </div>
      </div>
    );
  }
}
