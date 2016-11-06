package ru.rhome.hashtag.service.core.implementation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by R on 22.10.2016.
 */
class HashtagNode {

    public boolean isLeaf(){
        return word != null;
    }

    public boolean isRoot(){
        return phoneme == null;
    }

    public String getWord(){
        return word;
    }

    public void setWord(String word){
        this.word = word;
    }

    public String getPhoneme(){
        return phoneme;
    }

    private String phoneme;

    private String word;

    private Map<String, HashtagNode> children = new HashMap<String, HashtagNode>();

    public HashtagNode(){
        this(null);
    }

    public HashtagNode(String phoneme){
        this.phoneme = phoneme;
    }

    public void addChild(HashtagNode node){
        children.put(node.getPhoneme(), node);
    }

    public HashtagNode getChild(String phoneme){
        return children.get(phoneme);
    }
}
