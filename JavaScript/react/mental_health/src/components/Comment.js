import React from 'react';
import {connect} from 'react-redux';

const expandType = {
  isExpanded: "isExpanded",
  isNotExpanded: "isNotExpanded",
  canNotBeExpanded: "canNotBeExpanded"
}

class Comment extends React.Component {

  createActionList = (parentId) => {
    if(parentId == null) {
      return(
        <ul id="answer-list">
          <li>Answer</li>
          <li>Delete</li>
        </ul>
      );
    } else {
      return(
        <ul id="answer-list">
          <li>Delete</li>
        </ul>
      );
    }
  }

  createControlElement = (props) => {
    if(props.isAuthenticated) {
      return(
        <div style={{width: "30px"}}>
          <span id="answer-btn" onClick={props.onClickAnswerButton}>&#9660;</span>
          {this.createActionList(props.parentId)}
        </div>
      );
    }
  }

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

  getStars(parentId, rating) {
    if(parentId == null) {
      return(
        <div className="commentRating-view">
          <ul className="commentRating">
            <li id="stars" style={{width: (rating/5*100) + "%"}}/>
          </ul>
        </div>
      );
    }
  }

  render() {
    const {id, name, commentIsVisible, comment, expandType, parentId, rating} = this.props;
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
              {this.getStars(parentId, rating)}
            </div>
            {this.createControlElement(this.props)}
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
