const SET_COMMENT_BY_ID = "SET_COMMENT_BY_ID";

const setCommentById = (commentById) => {
  return {
    type: SET_COMMENT_BY_ID,
    commentById
  };
};

export {SET_COMMENT_BY_ID, setCommentById};
