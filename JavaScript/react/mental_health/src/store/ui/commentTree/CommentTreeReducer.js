import {expandType} from './../../../components/Comment';
import {SET_COMMENT_BY_ID, ADD_COMMENT, REMOVE_COMMENT} from './../../server/comment/CommentActions';
import {UPDATE_UI_PART_OF_COMMENT} from './uiCommentActions';

let startState = {
  uiPartOfCommentById: {}
};

const defineCommentExpandType = (comment) => {
  if(comment.childIds.length === 0) {
    return expandType.canNotBeExpanded;
  } else {
    return expandType.isExpanded;
  }
}

const handleSetCommentById = (action) => {
  let uiPartOfCommentById = {};

  let commentById = action.commentById;
  Object.keys(commentById).forEach(id => {
    uiPartOfCommentById[id] = {
      id: id,
      expandType: defineCommentExpandType(commentById[id])
    };
  });
  return {
    uiPartOfCommentById
  };
};

const handleAddComment = (state, action) => {
  let comment = action.comment;
  let uiPartOfCommentById = state.uiPartOfCommentById;
  let parentComment = uiPartOfCommentById[comment.parentId];
  if(parentComment) {
    return {
      uiPartOfCommentById: {
        ...uiPartOfCommentById,
        [comment.parentId]: {
          ...parentComment,
          expandType: expandType.isExpanded
        },
        [comment.id]: {
          id: comment.id,
          expandType: defineCommentExpandType(comment)
        }
      }
    }
  } else {
    return {
      uiPartOfCommentById: {
        ...uiPartOfCommentById,
        [comment.id]: {
          id: comment.id,
          expandType: defineCommentExpandType(comment)
        }
      }
    }
  }
};

const handleUpdateUiPartOfComment = (state, action) => {
  let newUiPartOfComment = action.uiPartOfComment;
  let oldUiPartOfComment = state.uiPartOfCommentById[newUiPartOfComment.id];
  return {
    uiPartOfCommentById: {
      ...state.uiPartOfCommentById,
      [newUiPartOfComment.id]: {
        ...oldUiPartOfComment,
        ...newUiPartOfComment
      }
    }
  }
}

const handleRemoveComment = (state, action, serverCommentListState) => {
  let uiPartOfCommentById = {...state.uiPartOfCommentById};
  const commentById = serverCommentListState.commentById;
  const comment = commentById[action.id];
  removeComment(uiPartOfCommentById, commentById, comment);

  return {
    uiPartOfCommentById
  };
}

const removeComment = (uiPartOfCommentById, commentById, comment) => {
  if(comment.childIds.length === 0) {
    delete uiPartOfCommentById[comment.id];
    return;
  }

  comment.childIds.forEach(child => removeComment(uiPartOfCommentById, commentById, child));
  delete uiPartOfCommentById[comment.id];
}

const commentTreeReducer = (state = startState, action, serverCommentListState) => {
  if(action.type === SET_COMMENT_BY_ID) {
    return handleSetCommentById(action);
  }

  if(action.type === ADD_COMMENT) {
    return handleAddComment(state, action);
  }

  if(action.type === UPDATE_UI_PART_OF_COMMENT) {
    return handleUpdateUiPartOfComment(state, action);
  };

  if(action.type === REMOVE_COMMENT) {
    return handleRemoveComment(state, action, serverCommentListState)
  }

  return state;
};

export default commentTreeReducer;
