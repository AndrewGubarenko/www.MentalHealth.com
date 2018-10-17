import {SET_USER_PLATE_BY_ID} from './UserPlateAction';

let startState = {
  userPlateById: {}
};

const userPlateReducer = (state = startState, action) => {
  if(action.type === SET_USER_PLATE_BY_ID) {
    return {
      userPlateById: action.userPlateById
    };
  };
  return state;
};

export default userPlateReducer;
