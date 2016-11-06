package ru.zinaliev.hashtag.service.implementation;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.zinaliev.hashtag.service.IHashtagDictionary;
import ru.zinaliev.hashtag.service.exceptions.NoSuchPhonemeException;
import ru.zinaliev.hashtag.service.exceptions.NoSuchWordException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by R on 21.10.2016.
 */
public class HashtagDictionaryTest {

    @Before
    public void setUp() throws Exception {
        words = new ArrayList<String>();
        words.add(0, "hat");
        words.add(1, "happy");
        words.add(2, "happily");
        words.add(3, "happiness");

        phonemes = new HashMap<String, List<String>>();
        phonemes.put(words.get(0), Lists.newArrayList("ˈhæ", "t"));
        phonemes.put(words.get(1), Lists.newArrayList("ˈhæ", "piˈ"));
        phonemes.put(words.get(2), Lists.newArrayList("ˈhæ", "pɪ", "li"));
        phonemes.put(words.get(3), Lists.newArrayList("ˈhæ", "pɪ", "nɪs"));

        tree = new HashtagDictionary();
    }

    private Map<String, List<String>> phonemes;
    private List<String> words;
    private IHashtagDictionary tree;

    @Test
    public void testPutWord_OnOnePhonemeWord_WordIsObtained() throws Exception {
        String word = words.get(0);

        tree.putWord(phonemes.get(word), word);

        Assert.assertEquals(word, tree.getWord(phonemes.get(word)));
    }

    @Test(expected = NoSuchPhonemeException.class)
    public void testGetWord_OnNotExistingPhoneme_ThrowsNoSuchPhonemeException() throws Exception {
        tree.getWord(Lists.newArrayList("none"));
    }

    @Test(expected = NoSuchWordException.class)
    public void testGetWord_OnInsufficientPhonemeSequence_ThrowsNoSuchWordException() throws Exception {
        String word = words.get(2);
        List<String> sequence = phonemes.get(word);

        tree.putWord(sequence, word);

        tree.getWord(Lists.newArrayList(sequence.get(0), sequence.get(1)));
    }
}
