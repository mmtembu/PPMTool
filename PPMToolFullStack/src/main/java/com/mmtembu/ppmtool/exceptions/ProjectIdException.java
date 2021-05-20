package com.mmtembu.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//This class Throws an exception
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException{

    //Constructor just takes a message String
    public ProjectIdException(String message) {
        super(message);
    }
}
