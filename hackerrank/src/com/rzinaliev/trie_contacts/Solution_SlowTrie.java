package com.rzinaliev.trie_contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rzinalie
 */
public class Solution_SlowTrie {

   static class Node{
      private char data;
      private List<Node> nodes = new ArrayList<Node>();
      private boolean isLeaf = false;

      public Node(char data){
         this.data = data;
      }

      public Node stores(char c){
         for(Node node : nodes){
            if(node.data == c){
               return node;
            }
         }

         return null;
      }

      public Node store(char c){
         Node result = new Node(c);
         nodes.add(result);
         return result;
      }

      public int getChildrenCount(){
         int result = 0;

         for(Node node : nodes){
            result += node.getChildrenCount();
         }

         if(isLeaf)
            result++;

         return result;

      }
   }

   public static final String CMD_ADD = "add";
   public static final String CMD_FIND = "find";

   private static Node root = new Node('.');

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int cmdCount = in.nextInt();

      for(int i = 0; i < cmdCount; i++){

         String cmdName = in.next();
         String cmdArg = in.next();

         if(CMD_ADD.equals(cmdName)) {
            add(cmdArg.toCharArray());
         }else if(CMD_FIND.equals(cmdName)){
            find(cmdArg.toCharArray());
         }else{
            throw new IllegalArgumentException("unsupported command: " + cmdName);
         }
      }
   }

   private static void find(char[] word) {
      Node currNode = root;

      for(char letter : word){
         currNode = currNode.stores(letter);

         if(currNode == null)
            break;
      }

      if(currNode == null)
         System.out.println("0");
      else
         System.out.println(currNode.getChildrenCount());
   }

   private static void add(char[] word){
      Node currNode = root;

      for(char letter : word){
         Node temp = currNode.stores(letter);

         if(temp != null){
            currNode = temp;
         }else{
            currNode = currNode.store(letter);
         }
      }

      if(currNode != null)
         currNode.isLeaf = true;
   }
}
