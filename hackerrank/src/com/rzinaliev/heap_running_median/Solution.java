package com.rzinaliev.heap_running_median;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author rzinalie
 */
public class Solution {
   public static void main(String[] args) {
      //mainInternal();
      mainTest();
   }

   static void mainInternal(){
      Scanner in = new Scanner(System.in);
      int cmdCount = in.nextInt();

      for(int i = 0; i < cmdCount; i++){
         int item = Integer.parseInt(in.next());
      }
   }

   static void mainTest(){
      Tree tree = new Tree();

      tree.add(5);
      tree.add(3);
      tree.add(7);
      tree.add(8);
      tree.add(6);
      tree.add(4);
      tree.add(2);

      System.out.println(tree);
   }

   /**
    * AVL tree node
    */
   static class Node{
      int data;
      int height;
      Node left;
      Node right;

      public Node(int data, int height){
         this.data = data;
         this.height = height;
      }

      public Node(int data){
         this(data, 0);
      }
   }

   /**
    * AVL Tree
    */
   static class Tree{
      private static final int INVALID_DATA = -1;

      Node root;
      int size;

      public void add(int data){
         if(root == null){
            root = new Node(data);
         }else{
            addInternal(root, data);
         }

         size++;
      }

      void addInternal(Node node, int data){

         if(data < node.data ){
            if(node.left == null){
               node.left = new Node(data);
            }else{
               addInternal(node.left, data);
            }
         }else if (data > node.data){
            if(node.right == null){
               node.right = new Node(data);
            }else{
               addInternal(node.right, data);
            }
         }else
            throw new RuntimeException("duplicate data : " + data);

         fixHeight(node);
      }

      void fixHeight(Node node){
         int leftH   = node.left    != null ? node.left.height    : 0;
         int rightH  = node.right   != null ? node.right.height   : 0;

         node.height = Math.max(leftH, rightH) + 1;
      }

      @Override
      public String toString() {
         StringBuilder sb = new StringBuilder();
         Queue<Node> nodes = new LinkedList<Node>();

         int curHeight = root.height;
         nodes.add(root);

         while( !nodes.isEmpty()){
            Node curNode = nodes.poll();

            if(curNode.height == INVALID_DATA)
               break;

            if(curHeight > curNode.height){
               sb.append('\n');
               curHeight = curNode.height;
            }

            sb.append(
                  String.format(
                     "%s%s:%s",
                     blankString(3 * curHeight + 1),
                     curNode.data == INVALID_DATA ? "x" : curNode.data,
                     curNode.height
                  )
            );

            if(curNode.data == INVALID_DATA){
               if(curNode.height > 0){
                  curNode.left = new Node(INVALID_DATA, curNode.height - 1);
                  curNode.right = new Node(INVALID_DATA, curNode.height - 1);
               }else{
                  continue;
               }
            }

            if(curNode.left != null){
               nodes.add(curNode.left);
            }else{
               nodes.add(new Node(INVALID_DATA, curNode.height - 1));
            }

            if(curNode.right != null){
               nodes.add(curNode.right);
            }else{
               nodes.add(new Node(INVALID_DATA, curNode.height - 1));
            }
         }

         sb.append('\n');
         sb.append("size: " + size);

         return sb.toString();
      }

      protected String blankString(int length) {
         if (length > 0) {
            char[] array = new char[length];
            Arrays.fill(array, ' ');
            return new String(array);
         }
         return "";
      }
   }
}
