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
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);

        int idx = 3;    // 시작 인덱스

        while(idx <= n){    // n번째 항까지 피보나치 연산 수행
            int val = list.get(idx-3)+list.get(idx-2)+list.get(idx-1);  // 앞의 3개 항 더하기
            list.add(val);

            idx++;
        }

        return list.get(n);
    }
}
