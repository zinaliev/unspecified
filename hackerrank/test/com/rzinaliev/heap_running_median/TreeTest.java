package com.rzinaliev.heap_running_median;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author rzinalie
 */
public class TreeTest {

   AvlTree tree;

   @Before
   public void setUp() throws Exception {
      tree = new AvlTree();
   }

   @After
   public void tearDown() throws Exception {
      //System.out.println(tree);
   }

   @Test
   public void testAdd_2_1_3() throws Exception {
      tree.add(2);
      tree.add(1);
      tree.add(3);

      AvlTree.Node root = tree.root;

      assertEquals(2, root.data);
      assertEquals(1, root.left.data);
      assertEquals(3, root.right.data);
   }

   @Test
   public void testAdd_1_2_3_LR() throws Exception {
      tree.add(1);
      tree.add(2);
      tree.add(3);

      AvlTree.Node root = tree.root;

      assertEquals(2, root.data);
      assertEquals(1, root.left.data);
      assertEquals(3, root.right.data);

      assertEquals(3, root.size);
      assertEquals(1, root.height);
   }

   @Test
   public void testAdd_3_2_1_RR() throws Exception {
      tree.add(3);
      tree.add(2);
      tree.add(1);

      AvlTree.Node root = tree.root;

      assertEquals(2, root.data);
      assertEquals(1, root.left.data);
      assertEquals(3, root.right.data);

      assertEquals(3, root.size);
      assertEquals(1, root.height);
   }

   @Test
   public void testAdd_3_1_2_LRR() throws Exception {
      tree.add(3);
      tree.add(1);
      tree.add(2);

      AvlTree.Node root = tree.root;

      assertEquals(2, root.data);
      assertEquals(1, root.left.data);
      assertEquals(3, root.right.data);
   }

   @Test
   public void testAdd_1_3_2_RLR() throws Exception {
      tree.add(1);
      tree.add(3);
      tree.add(2);

      AvlTree.Node root = tree.root;

      assertEquals(2, root.data);
      assertEquals(1, root.left.data);
      assertEquals(3, root.right.data);
   }

   @Test
   public void testAdd_5_3_7_8_6_4_2() throws Exception {
      tree.add(5);
      tree.add(3);
      tree.add(7);
      tree.add(8);
      tree.add(6);
      tree.add(4);
      tree.add(2);

      AvlTree.Node root = tree.root;

      assertEquals(5, root.data);

      assertEquals(3, root.left.data);
      assertEquals(7, root.right.data);

      assertEquals(2, root.left.left.data);
      assertEquals(4, root.left.right.data);

      assertEquals(6, root.right.left.data);
      assertEquals(8, root.right.right.data);
   }

   @Test
   public void testAdd_1_2_3_4_5_6_7_8_9() throws Exception {
      tree.add(1);
      tree.add(2);
      tree.add(3);
      tree.add(4);
      tree.add(5);
      tree.add(6);
      tree.add(7);
      tree.add(8);
      tree.add(9);

      AvlTree.Node root = tree.root;

      assertEquals(4, root.data);

      assertEquals(2, root.left.data);
      assertEquals(6, root.right.data);

      assertEquals(1, root.left.left.data);
      assertEquals(3, root.left.right.data);

      assertEquals(5, root.right.left.data);
      assertEquals(8, root.right.right.data);

      assertEquals(7, root.right.right.left.data);
      assertEquals(9, root.right.right.right.data);
   }

}