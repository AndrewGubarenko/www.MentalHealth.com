import React from 'react';
import CommentTree from './../components/CommentTree';
import {connect} from 'react-redux';

class CommentTreeContainer extends React.Component {
  render() {
    return(
      <CommentTree commentById={this.props.commentById}/>
    );
  }
}

const mapStateToProps = (state) => {
  var commentById = {};

  Object.getOwnPropertyNames(state.server.commentList.commentById).forEach(id => {
    let comment = state.server.commentList.commentById[id];
    let expandType = state.ui.commentTree.expandStateOfCommentById[id];
    commentById[id] = Object.assign({}, comment, {
      expandType: expandType,
      childsIds: []
    });
  });

  Object.getOwnPropertyNames(commentById).forEach(id => {
    let comment = commentById[id];
    if(comment.parentId) {
      let parent = commentById[comment.parentId];
      parent.childsIds.push(comment.id);
    }
  });

  return {
    commentById
  };
}

export default connect(mapStateToProps) (CommentTreeContainer);
