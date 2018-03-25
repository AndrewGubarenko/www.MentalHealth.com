import UserService from './../services/userService';
import UserEditorService from './../services/userEditorService';
import CommentService from './../services/CommentService';
import FormatDateUtils from './../utils/formatDateUtils';
import ImageUploader from './../utils/imageUploader';
import {createStore} from 'redux';
import mainReducer from './../store/MainReducer';

const store = createStore(mainReducer);

const startUrl = "http://localhost:8080/MentalHealth/";
const userService = new UserService(startUrl);
const userEditorService = new UserEditorService(startUrl);
const commentService = new CommentService(startUrl);
const formatDateUtils = new FormatDateUtils();
const imageUploader = new ImageUploader();

export {userService, userEditorService, formatDateUtils, imageUploader, store, commentService};
