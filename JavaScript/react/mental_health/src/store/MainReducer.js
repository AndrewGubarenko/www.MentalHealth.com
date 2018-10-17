import userReducer from './user/UserReducer';
import commentReducer from './server/comment/CommentReducer'
import userPlateReducer from './server/userPlate/UserPlateReducer'
import commentTreeReducer from './ui/commentTree/CommentTreeReducer'
import UserPlateRepresentationListReducer from './ui/userPlateList/UserPlateRepresentationListReducer'

let startState = {
  server: {

  },
  ui: {

  }
};

const mainReducer = (state = startState, action) => {
  return {
    server: {
      user: userReducer(state.server.user, action),
      commentList: commentReducer(state.server.commentList, action),
      userPlateList: userPlateReducer(state.server.userPlateList, action)
    },
    ui: {
      commentTree: commentTreeReducer(state.ui.commentTree, action, state.server.commentList),
      userPlateRepresentationList: UserPlateRepresentationListReducer(state.ui.userPlateRepresentationList, action, state.server.userPlateList)
    }
  };
};

export default mainReducer;
