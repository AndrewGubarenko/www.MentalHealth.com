import React from 'react'

export default class Registration extends React.Component {

  render(){
    return(
        <div className="FormStyle">

          <div className="FormStyle-block">
            <label className="form-label">Login:</label>
              <input className="form-control" type="text" onChange={this.props.onChangeLogin} value={this.props.login} />
          </div>

          <div className="FormStyle-block">
            <label className="form-label">Password:</label>
              <input className="form-control" type="password" onChange={this.props.onChangePassword} value={this.props.password} />
          </div>

          <div className="FormStyle-block">
            <button type="button" className="Button" onClick={this.props.onClickSignUp}>Sing Up</button>
          </div>

        </div>
    )
  }
}
