import React from 'react';
import {connect} from 'react-redux';
import Comment from './Comment';
import {expandType} from './Comment';
import CommentCreateFormContainer from './../containers/CommentCreateFormContainer';

class CommentTree extends React.Component {

  createTree(commentById) {
    let result = [];
    Object.values(commentById).filter(comment => comment.parentId == null).forEach(comment => {
      this.createTreeFromNode(commentById, comment, 0, result);
    });
    return result;
  }

  createTreeFromNode(commentById, comment, depth, result) {
    let marginLeft = this.props.indent * depth;
    result.push(
        <div className="comment_box" style={{marginLeft: marginLeft}} key={comment.id}>
          <Comment
            id={comment.id}
            name={comment.visitorName}
            rating={comment.rating}
            commentIsVisible={true}
            comment={comment.commentText}
            expandType={comment.expandType}
            parentId={comment.parentId}
            onClickAnswerButton={this.onClickAnswerButton}
            onClickExpand={this.props.onClickExpand}
            onClickDeleteComment={this.props.onClickDeleteComment}
            onClickDropDownButton={this.props.onClickDropDownButton}
            />
        </div>
      );
      if(comment.expandType === expandType.isExpanded) {
        comment.childIds.forEach(id => {
          let child = commentById[id];
          this.createTreeFromNode(commentById, child, depth + 1, result)
      });
    }
  }

  createCommentButton = () => {
    if(!this.props.isAuthenticated) {
      return(
        <div id="buttonContainer">
          <div id="button" onClick={this.props.onClickNewComment}>
            <div id="inscription">
              <span id="plus" style={{color: "#009999", fontSize: "18px", marginRight: "5px"}}>+</span>
              New comment</div>
            <div id="bottom-border"></div>
            <div id="right-border"></div>
          </div>
        </div>
      );
    }
  }

  render() {
    return(
      <div id="comments_container">
        {this.createCommentButton()}
        <CommentCreateFormContainer />
        {this.createTree(this.props.commentById)}
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return {isAuthenticated: state.server.user.isAuthenticated};
};

//function
let reduxContainerCreator = connect(mapStateToProps);
//React component class
let ReduxCommentTree = reduxContainerCreator(CommentTree);

export default ReduxCommentTree;
