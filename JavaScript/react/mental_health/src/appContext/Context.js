import UserService from './../services/userService'

const startUrl = "http://localhost:8080/MentalHealth/";
const userService = new UserService();
userService.setStartUrl(startUrl);

export {userService};
