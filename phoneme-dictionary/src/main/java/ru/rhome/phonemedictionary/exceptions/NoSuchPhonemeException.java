package ru.rhome.phonemedictionary.exceptions;

/**
 * Created by R on 22.10.2016.
 */
public class NoSuchPhonemeException extends RuntimeException{

    public NoSuchPhonemeException(String message){
        super(message);
    }
}
