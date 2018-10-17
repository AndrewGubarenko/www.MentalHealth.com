import {SET_COMMENT_BY_ID, ADD_COMMENT, REMOVE_COMMENT} from './CommentActions';

let commentByIdStateType = {
  empty: "empty",
  loading: "loading",
  loaded: "loaded",
  outOfDate: "outOfDate"
};

let startState = {
  state: commentByIdStateType.empty,
  commentById: {}
};

const handleAddComment = (state, action) => {
  let comment = action.comment;
  let commentById = state.commentById;
  let parentComment = commentById[comment.parentId];
  if(parentComment)  {
    return {
      state: state.state,
      commentById: {
        ...commentById,
        [parentComment.id]: {
          ...parentComment,
          childIds: [
            ...parentComment.childIds,
            comment.id
          ]
        },
        [comment.id]: comment
      }
    };
  } else {
      return {
        state: state.state,
        commentById: {
          ...commentById,
          [comment.id]: comment
        }
      };
    }
  }

const removeComment = (commentById, comment) => {
  if(comment.childIds.length === 0) {
    delete commentById[comment.id];

    const parentComment = commentById[comment.parentId];
    if(parentComment) {
      commentById[comment.parentId] = {
        ...parentComment,
        childIds: parentComment.childIds.filter(childId => (childId !== comment.id))
      };
    }
    return;
  }

  comment.childIds.forEach(child => removeComment(commentById, child));
  delete commentById[comment.id];

  let parentComment = commentById[comment.parentId];
  if(parentComment) {
    commentById[comment.parentId] = {
      ...parentComment,
      childIds: parentComment.childIds.filter(childId => (childId !== comment.id))
    };
  }
}

const commentReducer = (state = startState, action) => {
  if(action.type === SET_COMMENT_BY_ID) {
    return {
      state: commentByIdStateType.loaded,
      commentById: action.commentById
    };
  }

  if(action.type === ADD_COMMENT) {
    return handleAddComment(state, action);
  }

  if(action.type === REMOVE_COMMENT) {
    let commentById = {...state.commentById};
    let comment = commentById[action.id];

    removeComment(commentById, comment);

    return {
      state: state.state,
      commentById
    };
  }

  return state;
};

export default commentReducer;
export {commentByIdStateType};
