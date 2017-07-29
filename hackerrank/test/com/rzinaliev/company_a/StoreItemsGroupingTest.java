package com.rzinaliev.company_a;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author rzinalie
 */
public class StoreItemsGroupingTest {

   @Test
   public void testPositive_OneBiggestGroupOfThreeItems_FirstItemIsCommon() throws Exception {
      String[] result = new StoreItemsGrouping().getMaxGroup(new String[][]{
            {"Item1", "Item2"},
            {"Item1", "Item3"},
            {"Item4", "Item5"}
      });

      assertArrayEquals(new String[]{"Item1", "Item2", "Item3" }, result);
   }

   @Test
   public void testPositive_OneBiggestGroupOfThreeItems_SecondItemIsCommon() throws Exception {
      String[] result = new StoreItemsGrouping().getMaxGroup(new String[][]{
            {"Item1", "Item2"},
            {"Item2", "Item3"},
            {"Item4", "Item5"}
      });

      assertArrayEquals(new String[]{"Item1", "Item2", "Item3" }, result);
   }
}