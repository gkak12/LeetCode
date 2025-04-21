package com.leetcode;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.ArrayList;
import java.util.List;

public class NthTribonacciNumber {

    public static void main(String[] args) {
        int n = 25;
        int result = tribonacci(n);
        System.out.println(result);
    }

    public static int tribonacci(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(1);

        int idx = 3;

        while(idx <= n){
            int val = list.get(idx-3)+list.get(idx-2)+list.get(idx-1);
            list.add(val);

            idx++;
        }

        return list.get(n);
    }
}
