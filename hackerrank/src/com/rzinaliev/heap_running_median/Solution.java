package com.rzinaliev.heap_running_median;

import java.util.Scanner;

/**
 * Hackerrank challenge - https://www.hackerrank.com/challenges/find-the-running-median
 *
 * Actually using AVL Tree is not right choice here
 * TODO: We really need a combination of Min and Max Heaps
 */
public class Solution {

   /**
    * Actually using
    */
   static AvlTree tree = new AvlTree();

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int cmdCount = in.nextInt();

      for(int i = 0; i < cmdCount; i++){
         int item = Integer.parseInt(in.next());
         tree.add(item);
         System.out.println(findMedian());
      }
   }

   private static String findMedian() {
      float result = 0f;

      AvlTree.Node root = tree.root;
      if(root.size % 2 == 1){
         result = tree.root.data;
      }else if(AvlTree.size(root.left) >= AvlTree.size(root.right)){
         result = ((float)root.data + (float) AvlTree.findMax(root.left)) / 2.f;
      }else{
         result = ((float)root.data + (float) AvlTree.findMin(root.right)) / 2.f;
      }

      return String.format("%.1f", result);
   }

}
