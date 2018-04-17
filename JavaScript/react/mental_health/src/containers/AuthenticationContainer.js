import React from 'react';
import {userService} from './../appContext/Context';
import Authentication from './../components/Authentication';
import {setIsAuthenticated} from './../store/user/UserActions';
import {connect} from 'react-redux';

class AuthenticationContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      login: "",
      password: ""
    };
  }

  onChangeLogin = (event) => {
    this.setState({login: event.target.value});
  }

  onChangePassword = (event) => {
    this.setState({password: event.target.value});
  }

  onClickEnter = () => {
    userService.authentication(this.state).then(response => {
      console.log(response.id);
      return response.text();
    }).then(text => {
        localStorage.setItem("token", text);
        this.props.dispatch(setIsAuthenticated(true));
        this.props.history.push("/UserViewPage/" + this.props.id);
    });
  }

  render(){
    return(
      <Authentication
        login={this.state.login}
        onChangeLogin={this.onChangeLogin}
        password={this.state.password}
        onChangePassword={this.onChangePassword}
        onClickEnter={this.onClickEnter}
        />
    );
  }
}

const mapStateToProps = (state) => {
  let props = {
    isAuthenticated: state.server.user.isAuthenticated,
    id: 6
  };
  return props;
};

export default connect(mapStateToProps)(AuthenticationContainer);
