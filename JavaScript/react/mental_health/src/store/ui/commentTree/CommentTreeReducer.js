import {expandType} from './../../../components/Comment';
import {SET_COMMENT_BY_ID} from './../../server/comment/CommentActions';

let startState = {
  uiPartOfCommentById: {}
};

const handleSetCommentById = (action) => {
  let uiPartOfCommentById = {};

  let commentById = action.commentById;
  Object.keys(commentById).forEach(id => {
    let expand;
    let comment = commentById[id];
    if(comment.childIds.length === 0) {
      expand = expandType.canNotBeExpanded;
    } else {
      expand = expandType.isExpanded;
    }
    uiPartOfCommentById[id] = {
      expandType: expand
    };
  });
  return {
    uiPartOfCommentById
  };
};

const commentTreeReducer = (state = startState, action) => {
  if(action.type === SET_COMMENT_BY_ID) {
    return handleSetCommentById(action);
  }
  return state;
};

export default commentTreeReducer;
