package com.leetcode.easy.arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {7,2,3,7,7,8,9,7};
        System.out.println(nums.length);
        int len = removeElement(nums,7);
        System.out.println(len);
        for(int i=0;i<len;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }

            i++;
        }

        return j;
    }
}
