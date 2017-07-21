package com.rzinaliev.tree_level_order_traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rzinalie
 */
public class Solution {

   class Node {
      int data;
      Node left;
      Node right;
   }

   void levelOrder(Node root) {
      Queue<Node> nodes  = new LinkedList<Node>();

      nodes.add(root);

      while( !nodes.isEmpty()){
         Node curNode = nodes.poll();

         System.out.print(curNode.data + " ");

         if(curNode.left != null)
            nodes.add(curNode.left);

         if(curNode.right != null)
            nodes.add(curNode.right);
      }
   }

}
