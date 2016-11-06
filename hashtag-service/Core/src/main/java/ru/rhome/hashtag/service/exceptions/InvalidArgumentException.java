package ru.rhome.hashtag.service.exceptions;

/**
 * Created by R on 22.10.2016.
 */
public class InvalidArgumentException extends RuntimeException {

    public InvalidArgumentException(String argumentName){
        super(String.format("Invalid argument '%s'", argumentName));
    }
}
