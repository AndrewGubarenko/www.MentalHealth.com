import {SET_USER_PLATE_BY_ID} from './../../server/userPlate/UserPlateAction';

let startState = {
  uiPartOfUserPlateById: {}
};

const handleSetUserPlateById = (action) => {
  let uiPartOfUserPlateById = {};

  let userPlateById = action.userPlateById;
  Object.keys(userPlateById).forEach(id => {
    uiPartOfUserPlateById[id] = {
      id: id
    };
  });
  return {
    uiPartOfUserPlateById
  };
};

const UserPlateRepresentationListReducer = (state = startState, action) => {
  if(action.type === SET_USER_PLATE_BY_ID) {
    return handleSetUserPlateById(action);
  }
  return state;
};

export default UserPlateRepresentationListReducer;
