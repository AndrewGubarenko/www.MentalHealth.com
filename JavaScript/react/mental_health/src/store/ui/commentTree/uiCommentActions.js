const UPDATE_UI_PART_OF_COMMENT = "UPDATE_UI_PART_OF_COMMENT";

const updateUiPartOfComment = (uiPartOfComment) => {
  return {
    type: UPDATE_UI_PART_OF_COMMENT,
    uiPartOfComment: uiPartOfComment
  };
}

export {UPDATE_UI_PART_OF_COMMENT, updateUiPartOfComment};
