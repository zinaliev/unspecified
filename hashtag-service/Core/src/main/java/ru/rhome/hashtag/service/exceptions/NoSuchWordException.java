package ru.rhome.hashtag.service.exceptions;

/**
 * Created by R on 22.10.2016.
 */
public class NoSuchWordException extends RuntimeException{

    public NoSuchWordException(String message){
        super(message);
    }
}
