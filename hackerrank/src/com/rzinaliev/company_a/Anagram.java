package com.rzinaliev.company_a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given haystack and needle
 * Find all needle anagrams starting indexes in haystack
 *
 * Example:
 * Haystack  - "abcdefgbca"
 * Needle    - "cba"
 * Result    - "0, 7"
 */
public class Anagram {

   public List<Integer> findAnagramStartIndixes(String haystack, String needle){
      List<Integer> result = new ArrayList<Integer>();

      if(haystack == null || needle == null)
         return result;

      int haystackLen = haystack.length();
      int needleLen = needle.length();

      if(haystackLen == 0 || needleLen == 0 || needleLen > haystackLen)
         return result;

      needle = sort(needle);

      for(int i = 0; i <= haystackLen - needleLen; i++){
         String haystackPiece = sort(haystack.substring(i, i + needleLen));
         if(haystackPiece.equals(needle))
            result.add(i);
      }

      return result;
   }

   private String sort (String word){
      char[] letters = word.toCharArray();
      Arrays.sort(letters);
      return new String(letters);
   }

}
