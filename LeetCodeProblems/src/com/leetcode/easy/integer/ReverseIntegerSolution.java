package com.leetcode.easy.integer;

public class ReverseIntegerSolution {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        long rev = 0;
        while(x!=0){
            rev = rev*10 + x%10;
            if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE){
                return 0;
            }
            x = x/10;
        }
        return (int)rev;
    }
}
