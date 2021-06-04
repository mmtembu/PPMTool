import { combineReducers } from "redux";
import errorReduce from "./errorReducer";
import projectReduce from "./projectReducer";

export default combineReducers ({ 
    errors: errorReduce,
    project: projectReduce
});