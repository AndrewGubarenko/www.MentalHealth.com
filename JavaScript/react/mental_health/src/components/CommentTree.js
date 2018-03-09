import React from 'react';
import Comment from './Comment';
import {expandType} from './Comment';

export default class CommentTree extends React.Component {
  createTree(commentById) {
    return Object.values(commentById).filter(comment => comment.parentId == null).map(comment => {
      return this.createTreeFromNode(commentById, comment, 0);
    });
  }

  createTreeFromNode(commentById, comment, depth) {
    let marginLeft = 20* depth;
    return(
      <div>
        <div className="comment_box" style={{marginLeft: marginLeft}}>
          <Comment
            name={comment.name}
            commentIsVisible={true}
            comment={comment.comment}
            expandType={comment.expandType} />
        </div>
        {comment.expandType === expandType.isExpanded ?
          comment.childsIds.map(id => {
            let child = commentById[id];
            return this.createTreeFromNode(commentById, child, depth + 1);
          }) :
          null
        }
      </div>
    );
  }

  render() {
    return(
      <div id="comments_container">
        <div id="buttonContainer">
          <div id="button">
            <div id="inscription"><span id="plus">+</span>New comment</div>
            <div id="bottom-border"></div>
            <div id="right-border"></div>
          </div>
        </div>
        {this.createTree(this.props.commentById)}
        {/*<div className="comment_box">
          <Comment name="Comment" commentIsVisible={true} comment="" expandType="isExpanded" />
        </div>
        <div className="comment_box sub_comment_box">
          <Comment name="SubComment" expandType="isNotExpanded" />
        </div>
        <div className="comment_box">
          <Comment name="Comment" expandType="isNotExpanded" />
        </div>
        <div className="comment_box">
          <Comment name="Comment" expandType="isNotExpanded" />
        </div>*/}
      </div>
    )
  }
}
