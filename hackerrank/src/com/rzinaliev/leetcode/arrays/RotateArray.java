package com.rzinaliev.leetcode.arrays;

public class RotateArray {

  public void rotate(int[] nums, int k) {
    k = k % nums.length;

    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  public void reverse(int[] nums, int i, int j) {
    while (i < j) {
      nums[j] = nums[j] ^ nums[i];
      nums[i] = nums[j] ^ nums[i];
      nums[j] = nums[j] ^ nums[i];

      i++;
      j--;
    }
  }
}
