import {SET_COMMENT_BY_ID} from './CommentActions';

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

const commentReducer = (state = startState, action) => {
  if(action.type === SET_COMMENT_BY_ID) {
    return {
      state: commentByIdStateType.loaded,
      commentById: action.commentById
    };
  }
  return state;
};

export default commentReducer;
export {commentByIdStateType};
