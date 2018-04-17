import React from 'react';
import UserEditorContainer from './../containers/UserEditorContainer';

export default class UserEditorPage extends React.Component {
  getMode() {
    if(this.props.match.path === "/UserEditor/edit/:id") {
      return "edit";
    }
    if(this.props.match.path === "/UserEditor/new/") {
      return "new";
    }

    throw new Error("Unknown url!");
  }

  render() {
    return(
      <UserEditorContainer
        history={this.props.history}
        mode={this.getMode()}
        id={this.props.match.params.id}
      />
    );
  }
}
