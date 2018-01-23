import UserService from './../services/userService';
import UserEditorService from './../services/userEditorService';
import FormatDateUtils from './../utils/formatDateUtils';
import ImageUploader from './../utils/imageUploader';

const startUrl = "http://localhost:8080/MentalHealth/";
const userService = new UserService(startUrl);
const userEditorService = new UserEditorService(startUrl);
const formatDateUtils = new FormatDateUtils();
const imageUploader = new ImageUploader();

export {userService, userEditorService, formatDateUtils, imageUploader};
