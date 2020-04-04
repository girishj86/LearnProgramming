package com.leetcode.easy.string;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "floight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int i = 0;
        while (true) {
            boolean flag = true;
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].length() <= i || strs[j + 1].length() <= i
                        || strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                i++;
            } else {
                break;
            }
        }
        return strs[0].substring(0, i);
    }
}
