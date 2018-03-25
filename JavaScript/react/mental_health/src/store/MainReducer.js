import userReducer from './user/UserReducer';
import commentReducer from './server/comment/CommentReducer'
import commentTreeReducer from './ui/commentTree/CommentTreeReducer'

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
      commentList: commentReducer(state.server.commentList, action)
    },
    ui: {
      commentTree: commentTreeReducer(state.ui.commentTree, action)
    }
  };
};

export default mainReducer;
