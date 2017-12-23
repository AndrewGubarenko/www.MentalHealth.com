import React from 'react'
import {userService} from './../appContext/Context'
import UserCreate from './../components/UserCreate'

export default class UserCreateContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      Surname: "",
      speciality: "",
      essay: "",
      price: 100,
      currency: "UAH",
      experience: new Date(),
      birthday: new Date(),
      raiting: 0,
      phoneNumber: "",
      email: "",
      linkedin: "",
      facebook: "",
      skype: ""
    };
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

  onClickUpload = () => {

  }

  onClickSave = () => {
    userService.create(this.state).then(() => {
      return userService.authentication(this.state);
    }).then((response) => {
      return response.text();
    }).then(token => {
      localStorage.setItem("token", token);
      this.props.history.push("/userProfile");
    });
  }

  render(){
    return(
      <UserCreate
        firstName={this.state.firstName}
        onChangeFirstName={this.onChangeFirstName}
        SecondName={this.state.secondName}
        onChangeFirstNAme={this.onChangeSecondName}
        Speciality={this.state.speciality}
        onChangeSpeciality={this.onChangeSpeciality}
        Essay={this.state.essay}
        onChangeEssay={this.onChangeEssay}
        price={this.state.price}
        onChangePrice={this.onChangePrice}
        currency={this.state.currency}
        onChangeCurrency={this.onChangeCurrency}
        Experience={this.state.experience}
        onChangeExperience={this.onChangeExperience}
        Birthday={this.state.birthday}
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
        onClickUpload={this.onClickUpload}
        onClickSave={this.onClickSave}
        />
    )
  }
}
