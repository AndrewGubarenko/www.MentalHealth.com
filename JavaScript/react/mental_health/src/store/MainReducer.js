import userReducer from './user/UserReducer';

let startState = {
  server: {

  }
};

const mainReducer = (state = startState, action) => {
  return {
    server: {
      user: userReducer(state.server.user, action),
    }
  };
};

export default mainReducer;
