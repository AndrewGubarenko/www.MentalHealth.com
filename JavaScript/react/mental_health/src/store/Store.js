import { createStore } from 'redux';
import mainReducer from './MainReducer';

let store = createStore(userReducer);

export default store;
