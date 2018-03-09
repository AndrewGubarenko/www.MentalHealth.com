let startState = {
  state: "loaded",
  commentById: {
    1: {
      id: 1,
      parentId: null,
      name: "Comment 1",
      comment: "some comment 1",
      hasBeenRed: true
    },
    2: {
      id: 2,
      parentId: 1,
      name: "Comment 2",
      comment: "some comment 2",
      hasBeenRed: true
    },
    3: {
      id: 3,
      parentId: null,
      name: "Comment 3",
      comment: "some comment 3",
      hasBeenRed: false
    }
  }
};

const commentReducer = (state = startState, action) => {
  return state;
};

export default commentReducer;
