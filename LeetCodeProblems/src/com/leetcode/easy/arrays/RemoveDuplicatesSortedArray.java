package com.leetcode.easy.arrays;

public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,3,4,5,5,6,7,7,7,8};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for(int i=0;i<len;i++){
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int j = 0;
        int i = 1;

        while (i < nums.length) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }

            i++;
        }

        return j + 1;
    }
}
