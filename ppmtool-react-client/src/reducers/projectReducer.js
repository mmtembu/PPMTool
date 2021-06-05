import {GET_PROJECTS, GET_PROJECT} from "../actions/types";

const initialState = {
    projects:[],
    project:{}
};

export default function projectReduce(state = initialState, action){

    switch(action.type){
        case GET_PROJECT:
            return {
                ...state,
                project:action.payload
            };
        case GET_PROJECTS:
            return {
                ...state,
                projects:action.payload
            };
        default:
            return state;
    }
};

// export default projectReduce;