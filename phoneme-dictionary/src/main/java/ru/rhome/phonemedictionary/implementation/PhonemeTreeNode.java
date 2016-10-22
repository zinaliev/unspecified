package ru.rhome.phonemedictionary.implementation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by R on 22.10.2016.
 */
class PhonemeTreeNode {

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

    private Map<String, PhonemeTreeNode> children = new HashMap<String, PhonemeTreeNode>();

    public PhonemeTreeNode(){
        this(null);
    }

    public PhonemeTreeNode (String phoneme){
        this.phoneme = phoneme;
    }

    public void addChild(PhonemeTreeNode node){
        children.put(node.getPhoneme(), node);
    }

    public PhonemeTreeNode getChild(String phoneme){
        return children.get(phoneme);
    }
}
