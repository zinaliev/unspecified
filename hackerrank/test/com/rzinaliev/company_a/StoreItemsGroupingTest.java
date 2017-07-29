package com.rzinaliev.company_a;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author rzinalie
 */
public class StoreItemsGroupingTest {

   @Test
   public void testOneBiggestGroupOfThreeItems_FirstItemIsCommon() throws Exception {
      String[] result = new StoreItemsGrouping().getMaxGroup(new String[][]{
            {"Item1", "Item2"},
            {"Item1", "Item3"},
            {"Item4", "Item5"}
      });

      assertArrayEquals(new String[]{"Item1", "Item2", "Item3" }, result);
   }

   @Test
   public void testOneBiggestGroupOfThreeItems_SecondItemIsCommon() throws Exception {
      String[] result = new StoreItemsGrouping().getMaxGroup(new String[][]{
            {"Item1", "Item2"},
            {"Item2", "Item3"},
            {"Item4", "Item5"}
      });

      assertArrayEquals(new String[]{"Item1", "Item2", "Item3" }, result);
   }

   @Test
   public void testTwoBigGroups_MinItemIsInFirstGroup() throws Exception {
      String[] result = new StoreItemsGrouping().getMaxGroup(new String[][]{
            {"Item1", "Item2"},
            {"Item2", "Item3"},
            {"Item4", "Item5"},
            {"Item4", "Item6"}
      });

      assertArrayEquals(new String[]{"Item1", "Item2", "Item3" }, result);
   }

   @Test
   public void testTwoBigGroups_MinItemIsInSecondGroup() throws Exception {
      String[] result = new StoreItemsGrouping().getMaxGroup(new String[][]{
            {"Item1", "Item2"},
            {"Item2", "Item3"},
            {"Item4", "Item5"},
            {"Item4", "Item0"}
      });

      assertArrayEquals(new String[]{"Item4", "Item5", "Item0" }, result);
   }

   @Test
   public void testGroupsMerging() throws Exception {
      String[] result = new StoreItemsGrouping().getMaxGroup(new String[][]{
            {"Item1", "Item2"},
            {"Item2", "Item3"},
            {"Item5", "Item6"},
            {"Item1", "Item5"}
      });

      assertArrayEquals(new String[]{"Item1", "Item2", "Item3", "Item5", "Item6" }, result);
   }

   @Test
   public void testNegativeEmptyItemsArray() throws Exception {
      String[] result = new StoreItemsGrouping().getMaxGroup(new String[0][0]);

      assertArrayEquals(new String[0], result);
   }

}