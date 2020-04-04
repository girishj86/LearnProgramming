package com.leetcode.easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		Arrays.stream(twoSum(nums,9)).forEach(s->System.out.print(s+" "));

	}

	 public static int[] twoSum(int[] nums, int target) {
		 int[] solution = new int[2];
		 Map<Integer,Integer> map = new HashMap<>();
		 for(int i=0;i<nums.length;i++) {
			 if(map.containsKey(target-nums[i])) {
				solution[0]=map.get(target-nums[i]);
				solution[1]=i;
				return solution;
			 } else {
				 map.put(nums[i], i);
			 }
		 }
		return solution;
		
	    }
}
