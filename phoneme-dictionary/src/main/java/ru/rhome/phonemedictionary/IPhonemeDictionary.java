package ru.rhome.phonemedictionary;

import java.util.List;

/**
 * Created by R on 21.10.2016.
 */
public interface IPhonemeDictionary {

    String getWord(List<String> phonemes);

    void putWord(List<String> phonemes, String word);
}
