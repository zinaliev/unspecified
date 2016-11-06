package ru.zinaliev.hashtag.service.tools;


import ru.zinaliev.hashtag.service.exceptions.InvalidArgumentException;

import java.util.Collection;

/**
 * Created by R on 22.10.2016.
 */
public class Argument {

    public static void checkNotEmpty(String argument, String name){
        if(argument == null || argument.isEmpty())
            throw new InvalidArgumentException(name);
    }

    public static void check(Object argument, String name){
        if(argument == null)
            throw new InvalidArgumentException(name);
    }

    public static void checkCollection(Collection<?> collection, String name){
        if(collection == null || collection.size() == 0)
            throw new InvalidArgumentException(name);
    }
}
