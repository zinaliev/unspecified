package com.rzinaliev.company_a;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author rzinalie
 */
public class AnagramTest {

   @Test
   public void testNoAnagrams() throws Exception {
      List<Integer> result = new Anagram().findAnagramStartIndixes("abcd", "efg");

      assertEquals(0, result.size());
   }

   @Test
   public void testNoAnagrams_NeedleSizeIsGraterThanHaystacks() throws Exception {
      List<Integer> result = new Anagram().findAnagramStartIndixes("abcd", "efghijkl");

      assertEquals(0, result.size());
   }

   @Test
   public void testAnagramExists_OneLetterHaystackAndNeedle() throws Exception {
      List<Integer> result = new Anagram().findAnagramStartIndixes("a", "a");

      assertEquals(1, result.size());
      assertEquals(Integer.valueOf(0), result.get(0));
   }

   @Test
   public void testNoAnagram_OneLetterHaystackAndNeedle() throws Exception {
      List<Integer> result = new Anagram().findAnagramStartIndixes("a", "b");

      assertEquals(1, result.size());
      assertEquals(Integer.valueOf(0), result.get(0));
   }

   @Test
   public void testManyAnagramExist_OneLetterNeedle() throws Exception {
      List<Integer> result = new Anagram().findAnagramStartIndixes("aaaaa", "a");

      assertEquals(5, result.size());

      for(int i = 0; i < result.size(); i++)
         assertEquals(Integer.valueOf(i), result.get(i));
   }

   @Test
   public void testCloneAnagramExists() throws Exception {
      List<Integer> result = new Anagram().findAnagramStartIndixes("abcdefg", "efg");

      assertEquals(1, result.size());
      assertEquals(Integer.valueOf(4), result.get(0));
   }

   @Test
   public void testAnagramExists() throws Exception {
      List<Integer> result = new Anagram().findAnagramStartIndixes("abcdefg", "feg");

      assertEquals(1, result.size());
      assertEquals(Integer.valueOf(4), result.get(0));
   }
}