import React from 'react';
import {connect} from 'react-redux';
import {commentService} from './../appContext/Context';
import CommentCreateForm from './../components/CommentCreateForm';
import {addComment} from './../store/server/comment/CommentActions';

class CommentCreateFormContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      visitorName: "",
      rating: null,
      commentText: ""
    };
  }
  onChangeVisitorName = (event) => {
    this.setState({visitorName: event.target.value});
  }

  onChangeCommentText = (event) => {
    this.setState({commentText: event.target.value});
  }

  _getFormattedCommentToService() {
    let comment = {
      visitorName: this.state.visitorName,
      rating: document.querySelector('[name=reviewStars]:checked').value,
      commentText: this.state.commentText
    };
    return comment;
  }

  onClickSendComment = () => {
    let form = document.getElementById('comment-form-container');
    let button = document.getElementsByClassName('hidedButton');
    let comment = this._getFormattedCommentToService();
    commentService.create(comment, this.props.id).then(data => data.json()).then((comment) => {
      this.props.dispatch(addComment(comment));
      [].forEach.call(button, (item) => {
        item.style.transition = "0s";
      });
      form.style.display = "none";
    });
  }

  render() {
    return(
      <CommentCreateForm
        visitorName={this.state.visitorName}
        onChangeVisitorName={this.onChangeVisitorName}
        commentText={this.state.commentText}
        onChangeCommentText={this.onChangeCommentText}
        onClickSendComment={this.onClickSendComment}
      />
    );
  }
}

const mapStateToProps = (state) => {
  let props = {
    id: 6
  };
  return props;
};

export default connect(mapStateToProps)(CommentCreateFormContainer);
