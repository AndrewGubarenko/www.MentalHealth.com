import React from 'react';
import {connect} from 'react-redux';
import Comment from './Comment';
import {expandType} from './Comment';

const createCommentButton = (props) => {
  if(!props.isAuthenticated) {
    return(
      <div id="buttonContainer">
        <div id="button">
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
            name={comment.visitorName}
            commentIsVisible={true}
            comment={comment.commentText}
            expandType={comment.expandType}
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

  render() {
    return(
      <div id="comments_container">
        {createCommentButton(this.props)}
        {this.createTree(this.props.commentById)}
      </div>
    )
  }
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
let ReduxCommentTree = reduxContainerCreator(CommentTree);

export default ReduxCommentTree;
