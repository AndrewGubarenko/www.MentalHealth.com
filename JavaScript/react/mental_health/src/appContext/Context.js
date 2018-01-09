import UserService from './../services/userService';
import UserEditorService from './../services/userEditorService';
import FormatDataUtils from './../utils/formatDataUtils'

const startUrl = "http://localhost:8080/MentalHealth/";
const userService = new UserService(startUrl);
const userEditorService = new UserEditorService(startUrl);
const formatDataUtils = new FormatDataUtils();

export {userService, userEditorService, formatDataUtils};
