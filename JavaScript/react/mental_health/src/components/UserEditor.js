import React from 'react';
import './../css/UserEditor.css';
import './../css/button.css';

export default class UserEditor extends React.Component {

  render(){
    return(
        <div className="CreateFormStyle">

          <div>
            <div id="photoContainer">
              <img id="userPhoto" alt="" />
            </div>
            <div className="file-load-button">
            	<input type="file" id="inputImage" onChange={this.props.onChangeUserPhoto} />
            	<button id="uploadButton">Upload</button>
            </div>
          </div>

          <div className="FormStyle-block">
            <label className="form-label">Name:</label>
            <input className="form-control" type="text" onChange={this.props.onChangeName} value={this.props.name} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">Surname:</label>
            <input className="form-control" type="text" onChange={this.props.onChangeSurname} value={this.props.surname} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">Speciality:</label>
            <input className="form-control" type="text" placeholder="Psychological direction" onChange={this.props.onChangeSpeciality} value={this.props.speciality} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">Location:</label>
            <input className="form-control" type="text" placeholder="City of your work" onChange={this.props.onChangeLocation} value={this.props.location} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">Essay:</label>
            <textarea id="large-form-control" type="text" placeholder="Describe youself by a few words" onChange={this.props.onChangeEssay} value={this.props.essay} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">Price:</label>
            <input id="price-form-control" type="text" onChange={this.props.onChangePrice} value={this.props.price} />
              <select id="currency" onChange={this.props.onChangeCurrency} value={this.props.currency}>
                <option>UAH</option>
                <option>USD</option>
              </select>
          </div>

          <div className="FormStyle-block">
            <label className="form-label">Experience:</label>
            <input className="Calendar" type="date" onChange={this.props.onChangeExperience} value={this.props.experience} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">Birthday:</label>
            <input className="Calendar" type="date"  onChange={this.props.onChangeBirthday} value={this.props.birthday} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">Phone number:</label>
            <input className="form-control" type="tel" placeholder="+380-000-00-00" onChange={this.props.onChangePhoneNumber} value={this.props.phoneNumber} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">eMail:</label>
            <input className="form-control" type="email" placeholder="contact@example.com" onChange={this.props.onChangeEmail} value={this.props.email} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">LinkedIn:</label>
            <input className="form-control" type="href" placeholder="Link to your profile" onChange={this.props.onChangeLinkedin} value={this.props.linkedin} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">FaceBook:</label>
            <input className="form-control" type="href" placeholder="Link to your profile" onChange={this.props.onChangeFacebook} value={this.props.facebook} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">Skype:</label>
            <input className="form-control" type="text" placeholder="Your nickname in Skype" onChange={this.props.onChangeSkype} value={this.props.skype} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">University:</label>
            <input className="form-control" type="href" placeholder="University of your education" onChange={this.props.onChangeUniversity} value={this.props.university} />
          </div>

          <div>
            <div id="diplomaContainer">
              <img id="userDiploma" alt="" />
            </div>
            <div className="file-load-button">
            	<input type="file" id="inputImage" onChange={this.props.onChangeUserDiploma} />
            	<button id="uploadButton">Upload</button>
            </div>
          </div>

            <div id="buttonContainer" style={{float: "right", marginRight: "60px"}}>
              <div id="button" onClick={this.props.onClickSave}>
                <div id="inscription" style={{fontWeight: "500"}}>Save</div>
                <div id="bottom-border"></div>
                <div id="right-border"></div>
              </div>
            </div>

        </div>
    );
  }
}
