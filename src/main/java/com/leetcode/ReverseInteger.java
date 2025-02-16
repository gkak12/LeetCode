package com.leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/submissions/1277460289/
 */

public class ReverseInteger {

    public static void main(String[] args) {
        int x = 123;
        reverse(x);
    }

    public static int reverse(int x) {
        int answer = 0;

        while (x != 0) {
            int overflowCheck = answer * 10 + x % 10;

            if ((overflowCheck - x % 10) / 10 != answer) {
                return  0;
            }

            x /= 10;
            answer = overflowCheck;
        }

        return answer;
    }
}
