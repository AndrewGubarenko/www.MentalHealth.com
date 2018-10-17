const SET_USER_PLATE_BY_ID = "SET_USER_PLATE_BY_ID";

const setUserPlateById = (userPlateById) => {
  return {
    type: SET_USER_PLATE_BY_ID,
    userPlateById
  };
};

export {SET_USER_PLATE_BY_ID, setUserPlateById};
