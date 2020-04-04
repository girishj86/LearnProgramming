package com.leetcode.easy.integer;

public class PalindromeIntegerSolution {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x > 0 && x < 10) {
            return true;
        }
        //find how many digits
        int digits = 1;
        while (x / digits >= 10) {
            digits = digits * 10;
        }
        while (x != 0) {
            int left = x / digits;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % digits) / 10;
            if (x == 0) return true;
            digits = digits / 100;

        }
        return true;
    }
}
