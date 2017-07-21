package com.rzinaliev.balanced_brackets;

import java.util.*;

public class Solution {

   public static void main(String[] args) {

      Scanner in = new Scanner(System.in);
      int t = in.nextInt();
      for(int a0 = 0; a0 < t; a0++){
         String s = in.next();

         if(isBalanced(s.toCharArray()))
            System.out.println("YES");
         else
            System.out.println("NO");
      }
   }

   static boolean isBalanced(char[] brackets){
      Stack<Character> expression = new Stack<Character>();

      for(Character bracket : brackets){
         if(isOpening(bracket)){
            expression.push(bracket);
         }else{
            if(!expression.isEmpty()){
               Character lastBracket = expression.peek();
               if(lastBracket.equals(getOpening(bracket))){
                  expression.pop();
               }
            }else {
               expression.push(bracket);
            }
         }
      }
      return expression.isEmpty();
   }

   static boolean isOpening(Character bracket){
      if(bracket == null)
         return false;

      return bracket.equals('(') || bracket.equals('[') || bracket.equals('{');
   }

   static Character getOpening(Character closing){
      switch (closing){
         case ')':
            return '(';
         case ']':
            return '[';
         case '}':
            return '{';
         default:
            throw new IllegalArgumentException("invalid closing bracket: " + closing);
      }
   }
}
