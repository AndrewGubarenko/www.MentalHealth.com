import React from 'react';
import UserEditor from './../components/UserEditor';
import {formatDateUtils, userEditorService, imageUploader} from './../appContext/Context'

export default class UserEditorContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      surname: "",
      speciality: "",
      essay: "",
      price: 100,
      currency: "UAH",
      experience: formatDateUtils.formatToHtmlDateInput(new Date()),
      birthday: formatDateUtils.formatToHtmlDateInput(new Date()),
      rating: 0.0,
      phoneNumber: "",
      email: "",
      linkedin: "",
      facebook: "",
      skype: "",
      userPhotoSrc: "./images/instead-user-photo.jpg"
    };
  }



  componentDidMount() {
    document.getElementById('userPhoto').setAttribute('src', this.state.userPhotoSrc);
    if(this.props.mode === "edit") {
      userEditorService.get(this.props.id).then((data) => {
        return data.json();
      }).then(userProfile => {
        let result = Object.assign({}, userProfile, {
          experience:formatDateUtils.formatToHtmlDateInput(new Date(userProfile.experience)),
          birthday:formatDateUtils.formatToHtmlDateInput(new Date(userProfile.birthday))
        });
        this.setState(result);
      });
    }
  }

  onChangeName = (event) => {
    this.setState({name: event.target.value});
  }

  onChangeSurname = (event) => {
    this.setState({surname: event.target.value});
  }

  onChangeSpeciality = (event) => {
    this.setState({speciality: event.target.value});
  }

  onChangeEssay = (event) => {
    this.setState({essay: event.target.value});
  }

  onChangePrice = (event) => {
    this.setState({price: event.target.value});
  }

  onChangeCurrency = (event) => {
    this.setState({currency: event.target.value});
  }

  onChangeExperience = (event) => {
    this.setState({experience: event.target.value});
  }

  onChangeBirthday = (event) => {
    this.setState({birthday: event.target.value});
  }

  onChangePhoneNumber = (event) => {
    this.setState({phoneNumber: event.target.value});
  }

  onChangeEmail = (event) => {
    this.setState({email: event.target.value});
  }

  onChangeLinkedin = (event) => {
    this.setState({linkedin: event.target.value});
  }

  onChangeFacebook = (event) => {
    this.setState({facebook: event.target.value});
  }

  onChangeSkype = (event) => {
    this.setState({skype: event.target.value});
  }

  onChangeUserPhoto = (event) => {
    imageUploader.imageUpload(event)
    //TODO: implement saving photo to correct path
    this.setState({userPhotoSrc: event.target.value})
  }

  _getFormattedProfileToService() {
    let userProfile = {
      id: this.props.id,
      name: this.state.name,
      surname: this.state.surname,
      speciality: this.state.speciality,
      essay: this.state.essay,
      price: this.state.price,
      currency: this.state.currency,
      rating: this.state.rating,
      experience: formatDateUtils.formatToDate(this.state.experience),
      birthday: formatDateUtils.formatToDate(this.state.birthday),
      phoneNumber: this.state.phoneNumber,
      email: this.state.email,
      linkedin: this.state.linkedin,
      facebook: this.state.facebook,
      skype: this.state.skype,
      userPhotoSrc: this.state.userPhotoSrc
    };
    return userProfile;
  }

  onClickSave = () => {
    let userProfile = this._getFormattedProfileToService();
    if(this.props.mode === "new") {
      userEditorService.create(userProfile).then(() => {
        this.props.history.goBack();
      });
    }
    if(this.props.mode === "edit") {
      userEditorService.update(userProfile).then(() => {
        this.props.history.goBack();
      });
    }
  }

  render(){
    return(
      <UserEditor
        name={this.state.name}
        onChangeName={this.onChangeName}
        surname={this.state.surname}
        onChangeSurname={this.onChangeSurname}
        speciality={this.state.speciality}
        onChangeSpeciality={this.onChangeSpeciality}
        essay={this.state.essay}
        onChangeEssay={this.onChangeEssay}
        price={this.state.price}
        onChangePrice={this.onChangePrice}
        currency={this.state.currency}
        onChangeCurrency={this.onChangeCurrency}
        experience={this.state.experience}
        onChangeExperience={this.onChangeExperience}
        birthday={this.state.birthday}
        onChangeBirthday={this.onChangeBirthday}
        phoneNumber={this.state.phoneNumber}
        onChangePhoneNumber={this.onChangePhoneNumber}
        email={this.state.email}
        onChangeEmail={this.onChangeEmail}
        linkedin={this.state.linkedin}
        onChangeLinkedin={this.onChangeLinkedin}
        facebook={this.state.facebook}
        onChangeFacebook={this.onChangeFacebook}
        skype={this.state.skype}
        onChangeSkype={this.onChangeSkype}
        userPhotoSrc={this.state.userPhotoSrc}
        onChangeUserPhoto={this.onChangeUserPhoto}
        onClickSave={this.onClickSave}
        />
    );
  }
}
