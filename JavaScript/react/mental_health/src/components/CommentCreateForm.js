import React from 'react';
import './../css/commentCreateForm.css';

export default class CommentCreateForm extends React.Component {

  render() {
    return(
      <div id="comment-form-container">

        <div className="comment-style-block">
          <label className="comment-label">Visitor name:</label>
          <input id="comment-control" type="text" onChange={this.props.onChangeVisitorName} value={this.props.visitorName} />
        </div>
        <div className="comment-style-block">
          <label className="comment-label">Set rating:</label>
          <div id="comment-stars-input">
            <input id="star-4" type="radio" name="reviewStars" value="5"/>
            <label title="Excellent" htmlFor="star-4"></label>

            <input id="star-3" type="radio" name="reviewStars" value="4"/>
            <label title="Good" htmlFor="star-3"></label>

            <input id="star-2" type="radio" name="reviewStars" value="3"/>
            <label title="Satisfactorily" htmlFor="star-2"></label>

            <input id="star-1" type="radio" name="reviewStars" value="2"/>
            <label title="Poor" htmlFor="star-1"></label>

            <input id="star-0" type="radio" name="reviewStars" value="1"/>
            <label title="Unacceptable" htmlFor="star-0"></label>
          </div>
        </div>

        <div className="comment-style-block">
          <label className="comment-label">Comment:</label>
          <textarea id="comment-form-control" type="text" placeholder="Write your comment" onChange={this.props.onChangeCommentText} value={this.props.commentText} />
        </div>

        <div id="buttonContainer" style={{'--buttonFloat': 'right'}}>
          <div id="button" className="hidedButton" style={{'--buttonColor': '#02364c'}} onClick={this.props.onClickSendComment}>
            <div id="inscription" className="hidedButton">Send comment</div>
            <div id="bottom-border" className="hidedButton"></div>
            <div id="right-border" className="hidedButton"></div>
          </div>
        </div>

      </div>
    );
  }
}
