package ru.zinaliev.hashtag.service.core;

import java.util.List;

/**
 * Created by R on 21.10.2016.
 */
public interface IHashtagDictionary {

    String getWord(List<String> phonemes);

    void putWord(List<String> phonemes, String word);
}
