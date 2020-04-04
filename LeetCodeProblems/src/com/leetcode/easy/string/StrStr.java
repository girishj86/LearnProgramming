package com.leetcode.easy.string;

public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.trim().isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()){
            return -1;
        }
        boolean flag = false;
        for (int i = 0; i < haystack.length(); i++) {
            int m = i;
            for (int j = 0; j < needle.length(); j++) {
                if (m < haystack.length() && haystack.charAt(m) == needle.charAt(j)) {
                    m++;
                    if (j == needle.length() - 1) {
                        return i;
                    }
                } else {

                    break;
                }
            }
        }
        return -1;
    }
}
