package com.rzinaliev.heap_running_median;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author rzinalie
 */
public class HeapTest {

   @Test
   public void testRemoveFromBottom_1_2_3_4_5() throws Exception {
      Solution.Heap heapMax = Solution.Heap.newMaxHeap();

      heapMax.add(1);
      heapMax.add(2);
      heapMax.add(3);
      heapMax.add(4);
      heapMax.add(5);

      Solution.Heap heapMin = Solution.Heap.newMinHeap();

      heapMin.add(1);
      heapMin.add(2);
      heapMin.add(3);
      heapMin.add(4);
      heapMin.add(5);

      for(int i = 1; i < 5; i++){
         System.out.println("max: " + heapMax.removeBottom(heapMax.root));
         System.out.println("min: " + heapMin.removeBottom(heapMin.root));

         assertEquals(5 - i, heapMax.root.size);
         assertEquals(5, heapMax.root.data);

         assertEquals(5 - i, heapMin.root.size);
         assertEquals(1, heapMin.root.data);
      }
   }

   @Test
   public void testRemoveRoot_1_2_3_4_5() throws Exception {
      Solution.Heap heapMax = Solution.Heap.newMaxHeap();

      heapMax.add(1);
      heapMax.add(2);
      heapMax.add(3);
      heapMax.add(4);
      heapMax.add(5);

      Solution.Heap heapMin = Solution.Heap.newMinHeap();

      heapMin.add(1);
      heapMin.add(2);
      heapMin.add(3);
      heapMin.add(4);
      heapMin.add(5);

      for(int i = 1; i <= 5; i++){

         int rootMax = heapMax.removeRoot();
         int rootMin = heapMin.removeRoot();

         System.out.println("max: " + rootMax);
         System.out.println("min: " + rootMin);

         assertEquals(5 - i, heapMax.size());
         assertEquals(5 - i, heapMin.size());

         assertEquals(6 - i, rootMax);
         assertEquals(i, rootMin);
      }
   }
}