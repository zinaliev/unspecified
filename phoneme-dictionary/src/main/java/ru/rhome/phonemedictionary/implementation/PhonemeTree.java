package ru.rhome.phonemedictionary.implementation;

import com.google.common.base.Joiner;
import ru.rhome.phonemedictionary.IPhonemeDictionary;
import ru.rhome.phonemedictionary.exceptions.NoSuchPhonemeException;
import ru.rhome.phonemedictionary.exceptions.NoSuchWordException;
import ru.rhome.phonemedictionary.implementation.tools.Argument;

import java.util.Iterator;
import java.util.List;

/**
 * Created by R on 21.10.2016.
 */
class PhonemeTree implements IPhonemeDictionary {

    PhonemeTreeNode rootNode = new PhonemeTreeNode();

    public String getWord(List<String> phonemes) {
        Argument.checkCollection(phonemes, "phonemes");

        Iterator<String> phonemesIterator = phonemes.iterator();
        PhonemeTreeNode parentNode = rootNode;
        PhonemeTreeNode childNode;

        for(int i = 0; i < phonemes.size(); i++){
            childNode = parentNode.getChild(phonemes.get(i));

            if(childNode == null) {
                throw new NoSuchPhonemeException(String.format("No info stored for phoneme #%s '%s' in sequence '%s'",
                        i + 1,
                        phonemes.get(i),
                        Joiner.on(' ').join(phonemes)
                ));
            }

            parentNode = childNode;
        }

        if(!parentNode.isLeaf()){
            throw new NoSuchWordException(String.format("No word stored for phonemes sequence '%s'",
                    Joiner.on(' ').join(phonemes)
            ));
        }

        return parentNode.getWord();
    }

    public void putWord(List<String> phonemes, String word) {
        Argument.checkCollection(phonemes, "phonemes");
        Argument.checkNotEmpty(word, "word");

        Iterator<String> phonemesIterator = phonemes.iterator();
        PhonemeTreeNode parentNode = rootNode;
        PhonemeTreeNode childNode = null;

        while(phonemesIterator.hasNext()){
            childNode = new PhonemeTreeNode(phonemesIterator.next());
            parentNode.addChild(childNode);
            parentNode = childNode;
        }

        if(childNode != null){
            childNode.setWord(word);
        }
    }
}
