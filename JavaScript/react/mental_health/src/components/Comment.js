import React from 'react';
import {connect} from 'react-redux';

const expandType = {
  isExpanded: "isExpanded",
  isNotExpanded: "isNotExpanded",
  canNotBeExpanded: "canNotBeExpanded"
}

const createControlElement = (props) => {
  if(props.isAuthenticated) {
    return(
      <div style={{width: "60px"}}>
        <a className="answer-btn">Answer</a>
      </div>
    );
  }
}

class Comment extends React.Component {
  getExpandSpan(expandType) {
    if(expandType === "isExpanded") {
      return(
        <span className="roll-up">&#5123;</span>
      );
    }

    if(expandType === "isNotExpanded") {
      return(
        <span className="roll-down">&#5121;</span>
      );
    }

    if(expandType === "canNotBeExpanded") {
      return null;
    }

    return null;
  }

  render() {
    const {name, commentIsVisible, comment, expandType} = this.props;
      return(
        <div>
          <div style={{display: "flex", flexDirection: "row", justifyContent: "space-between", alignItems: "center", padding: "5px"}}>
            <div style={{width: "20px", fontSize: "7pt"}}>
              {this.getExpandSpan(expandType)}
            </div>
            <div style={{flexGrow: 1, marginRight: "30px"}}>
              <span style={{cursor: "pointer"}}>
                {name}
              </span>
            </div>
            {createControlElement(this.props)}
          </div>
          {commentIsVisible ? (
              <div style={{marginLeft: "20px", marginRight: "50px", color: "grey", fontStyle: "italic"}}>
                {comment}
              </div>
            ): undefined}
        </div>
      );
    };
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
  let ReduxComment = reduxContainerCreator(Comment);

  export default ReduxComment;
  export {expandType};
