package com.rzinaliev.heap_running_median;

import javax.swing.tree.FixedHeightLayoutCache;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author rzinalie
 */
public class Solution {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int cmdCount = in.nextInt();

      for(int i = 0; i < cmdCount; i++){
         int item = Integer.parseInt(in.next());
      }
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

      @Override
      public String toString() {
         return String.format("%s:%s", data, height);
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
            root = addInternal(root, data);
         }

         size++;
      }

      Node addInternal(Node node, int data){

         if(node == null){
            node = new Node(data);
         }else if(data < node.data){
            node.left = addInternal(node.left, data);

            if(balanceFactor(node) > 1){
               if(data < node.left.data){
                  node = rightRotation(node);
               }else{
                  node = leftRightRotation(node);
               }
            }
         }else if(data > node.data){
            node.right = addInternal(node.right, data);

            if(balanceFactor(node) < -1){
               if(data > node.right.data){
                  node = leftRotation(node);
               }else{
                  node = rightLeftRotation(node);
               }
            }
         }else{
            throw new RuntimeException("duplicate data : " + data);
         }

         fixHeight(node);
         return node;
      }

      private Node rightLeftRotation(Node parent) {
         parent.right = rightRotation(parent.right);
         return leftRotation(parent);
      }

      private Node leftRightRotation(Node parent) {
         parent.left = leftRotation(parent.left);
         return rightRotation(parent);
      }

      private Node leftRotation(Node parent) {
         Node child = parent.right;

         parent.right = child.left;
         child.left = parent;

         fixHeight(parent);
         child.height = Math.max(height(parent), height(child.right)) + 1;

         return child;
      }

      private Node rightRotation(Node parent) {

         Node child = parent.left;

         parent.left = child.right;
         child.right = parent;

         fixHeight(parent);
         child.height = Math.max(height(parent), height(child.left)) + 1;

         return child;
      }

      void fixHeight(Node node){
         int leftH = height(node.left);
         int rightH = height(node.right);

         node.height = Math.max(leftH, rightH) + 1;
      }

      int height(Node node){
         return node != null ? node.height : -1;
      }

      int balanceFactor(Node node){
         if (node == null)
            return INVALID_DATA;

         return height(node.left) - height(node.right);
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
