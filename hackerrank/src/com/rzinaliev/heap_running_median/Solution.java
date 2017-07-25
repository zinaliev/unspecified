package com.rzinaliev.heap_running_median;

import java.util.Scanner;

/**
 * Hackerrank challenge - https://www.hackerrank.com/challenges/find-the-running-median
 *
 */
public class Solution {

   static Heap heapMin = Heap.newMinHeap();
   static Heap heapMax = Heap.newMaxHeap();

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int cmdCount = in.nextInt();

      for(int i = 0; i < cmdCount; i++){
         int item = Integer.parseInt(in.next());

         if(heapMin.size() == 0){
            heapMin.add(item);
         }else if(heapMax.size() == 0){
            heapMax.add(item);
         }else{
            if(item > heapMax.root()){
               heapMin.add(item);
            }else{
               heapMax.add(item);
            }
         }

         int sizeDiff = heapMin.size() - heapMax.size();

         if(sizeDiff > 1){
            heapMax.add(heapMin.removeRoot());
         }else if (sizeDiff < -1){
            heapMin.add(heapMax.removeRoot());
         }else if (sizeDiff == 0){
            if(heapMin.root() < heapMax.root()){
               int hmr = heapMin.removeRoot();
               heapMin.add(heapMax.removeRoot());
               heapMax.add(hmr);

               System.out.println("swap roots");
               System.out.println(heapMin);
               System.out.println(heapMax);
               System.out.println();

            }
         }

         System.out.println(findMedian());
         System.out.println(heapMin);
         System.out.println(heapMax);
         System.out.println();
      }
   }

   private static String findMedian() {
      float result = 0f;

      int sizeDiff = heapMin.size() - heapMax.size();

      if(sizeDiff == 0){
         result = ((float)heapMin.root() +(float)heapMax.root()) / 2.f;
      }else if(sizeDiff == 1){
         result = heapMin.root();
      }else if (sizeDiff == -1){
         result = heapMax.root();
      }else{
         throw new RuntimeException("heaps are not rebalanced");
      }

      return String.format("%.1f", result);
   }

   /**
    * @author rzinalie
    */
   public static class Heap {

      static final int INVALID = -1;

      boolean isMax = true;
      Node root;

      private Heap(boolean isMax){
         this.isMax = isMax;
      }

      public static Heap newMaxHeap(){
         return new Heap(true);
      }

      public static Heap newMinHeap(){
         return new Heap(false);
      }

      static class Node {
         int data;
         int size;
         Node left;
         Node right;

         Node(int data){
            this.data = data;
            this.size = 1;
         }

         @Override
         public String toString() {
            return String.format("%s:%s", data, size);
         }
      }

      public void add(int data){
         root = addInternal(root, data);
      }

      public int removeRoot(){
         int result = INVALID;

         if(size(root) == 0)
            return result;

         if(size(root) == 1){
            result = root.data;
            root = null;
            return result;
         }

         result = root.data;

         root.data = removeBottom(root).data;

         Node curNode = root;
         fixSize(curNode);

         // new root value is retrieved from bottom leaf so
         // now we need to 'place' it properly by swapping nodes
         while (true) {
            if (size(curNode) == 1)
               break;

            if (compare(curNode.left, curNode.right) > 0) {
               if (needToSwap(curNode.left, curNode))
                  curNode = swapDataWithLeftChild(curNode);
               else
                  break;

            } else {
               if (needToSwap(curNode.right, curNode))
                  curNode = swapDataWithRightChild(curNode);
               else
                  break;
            }
         }

         return result;
      }

      public int size(){
         return size(root);
      }

      public int root(){
         return data(root);
      }

      Node addInternal (Node node, int data){
         if(node == null){
            node = new Node(data);
         }else if(sizeBalance(node) >= 1){
            node.right = addInternal(node.right, data);

            if(needToSwap(node.right, node)){
               node = swapWithRightChild(node);
            }
         }else{
            node.left = addInternal(node.left, data);

            if(needToSwap(node.left, node)){
               node = swapWithLeftChild(node);
            }
         }

         fixSize(node);
         return node;
      }

      Node swapWithLeftChild(Node parent){
         Node child = parent.left;

         parent.left = child.left;
         child.left = parent;

         Node temp = parent.right;
         parent.right = child.right;
         child.right = temp;

         fixSize(parent);
         fixSize(child);

         return child;
      }

      Node swapWithRightChild(Node parent){
         Node child = parent.right;

         parent.right = child.right;
         child.right = parent;

         Node temp = parent.left;
         parent.left = child.left;
         child.left = temp;

         fixSize(parent);
         fixSize(child);

         return child;
      }



      private Node swapDataWithRightChild(Node parent) {

         Node child = parent.right;

         int temp = parent.data;
         parent.data = child.data;
         child.data = temp;

         return child;
      }

      private Node swapDataWithLeftChild(Node parent) {
         Node child = parent.left;

         int temp = parent.data;
         parent.data = child.data;
         child.data = temp;

         return child;
      }

      Node removeBottom(Node node){
         if(size(node) == 1){
            return node;
         }

         Node current;

         if(removeFromRight(node.left, node.right)){
            current = removeBottom(node.right);
            if(size(current) == 1 && node.right.data == current.data){
               node.right = null;
            }
         }else{
            current = removeBottom(node.left);
            if(size(current) == 1 && node.left.data == current.data){
               node.left = null;
            }
         }

         fixSize(node);

         return current;
      }

      boolean needToSwap(Node child, Node parent){
         if(isMax){
            return child != null && child.data > parent.data;
         }else{
            return child != null && child.data < parent.data;
         }
      }

      int compare (Node n1, Node n2){
         if(isMax){
            return data(n1) - data(n2);
         }else{
            return data(n2) - data(n1);
         }
      }

      int data(Node node){
         if(isMax){
            return node != null ? node.data : Integer.MIN_VALUE;
         }else{
            return node != null ? node.data : Integer.MAX_VALUE;
         }

      }

      boolean removeFromRight(Node left, Node right){
         return size(right) > size(left);
      }

      int sizeBalance(Node node){
         return size(node.left) - size(node.right);
      }

      int size(Node node){
         return node != null ? node.size : 0;
      }

      void fixSize(Node node){
         if(node != null){
            node.size = size(node.left) + size(node.right) + 1;
         }
      }

      @Override
      public String toString() {
         return String.format("%s, r:%s, s:%s",
               isMax ? "max" : "min",
               root(),
               size()
         );
      }
   }
}
