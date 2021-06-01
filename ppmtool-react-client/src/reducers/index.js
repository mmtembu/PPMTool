import { combineReducers } from "redux";
import errorReduce from "./errorReducer";

export default combineReducers ({
    errors: errorReduce
});