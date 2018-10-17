const SET_COMMENT_BY_ID = "SET_COMMENT_BY_ID";

const setCommentById = (commentById) => {
  return {
    type: SET_COMMENT_BY_ID,
    commentById
  };
};

export {SET_COMMENT_BY_ID, setCommentById};

const ADD_COMMENT = "ADD_COMMENT";

const addComment = (comment) => {
  return {
    type: ADD_COMMENT,
    comment
  };
};

export {ADD_COMMENT, addComment};

const REMOVE_COMMENT = 'REMOVE_COMMENT';

const removeComment = (id) => {
  return {
    type: REMOVE_COMMENT,
    id
  };
};

export {removeComment, REMOVE_COMMENT}
