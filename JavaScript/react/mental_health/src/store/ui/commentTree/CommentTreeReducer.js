import {expandType} from './../../../components/Comment';

let startState = {
  expandStateOfCommentById: {
    1: expandType.isExpanded,
    2: expandType.isExpanded,
    3: expandType.isNotExpanded
  }
};

const commentTreeReducer = (state = startState, action) => {
  return state;
};

export default commentTreeReducer;
