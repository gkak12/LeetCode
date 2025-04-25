package com.leetcode;

/**
 * https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75
 */

public class IsSubsequence {

    public static void main(String[] args) {
//        String s = "abc";
//        String t = "ahbgdc";
        String s = "axc";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty()){    // s문자열이 공백인 경우
            return false;
        }

        int sIdx = 0;

        for(int idx = 0 ; idx < t.length() ; idx++){
            if(sIdx < s.length() && s.charAt(sIdx) == t.charAt(idx)){   // s문자열이 t문자열의 일부인 경우 
                sIdx++;
            }
        }

        boolean flag = sIdx == s.length() ? true : false;   // sIdx가 s문자열을 다 검사한 경우 true 리턴
        return flag;
    }
}
