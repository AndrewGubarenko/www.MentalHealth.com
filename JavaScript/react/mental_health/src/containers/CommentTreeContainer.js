import React from 'react';
import ReactDOM from 'react-dom';
import CommentTree from './../components/CommentTree';
import {connect} from 'react-redux';
import {commentByIdStateType} from './../store/server/comment/CommentReducer';
import {visitorService} from './../appContext/Context';
import {setCommentById} from './../store/server/comment/CommentActions';

class CommentTreeContainer extends React.Component {

  componentDidMount() {
    let commentByIdState  = this.props.commentByIdState;

    if (commentByIdState !== commentByIdStateType.empty
      && commentByIdState !== commentByIdStateType.outOfDate) {
        return;
      }
      visitorService.getFullProfile(this.props.id).then(data => data.json()).then(dataList => {
        return dataList[1];
      }).then(commentList => {
        let commentById = {};
        commentList.forEach(comment => {
          commentById[comment.id] = comment;
        });
        this.props.dispatch(setCommentById(commentById));
      });
  }

  onClickNewComment = () => {
    let form = document.getElementById('comment-form-container');
    let button = document.getElementsByClassName('hidedButton');
    if(getComputedStyle(form).display === "none") {
      form.style.display = "inline-block";
      [].forEach.call(button, (item) => {
        item.style.transition = "0.75s";
      });
    } else if(getComputedStyle(form).display === "inline-block") {
      [].forEach.call(button, (item) => {
        item.style.transition = "0s";
      });
      form.style.display = "none";
    }
  }

  render() {
    return(
      <CommentTree
        onClickNewComment = {this.onClickNewComment}
        {...this.props}
        indent={20}
      />
    );
  }
}

const mapStateToProps = (state) => {
  var commentById = {};

  Object.values(state.server.commentList.commentById).forEach(comment => {
    let uiPartOfComment = state.ui.commentTree.uiPartOfCommentById[comment.id];
    commentById[comment.id] = Object.assign({}, comment, {
      expandType: uiPartOfComment.expandType
    });
  });

  return {
    commentById,
    commentByIdState: state.server.commentList.state
  };
}

export default connect(mapStateToProps)(CommentTreeContainer);
