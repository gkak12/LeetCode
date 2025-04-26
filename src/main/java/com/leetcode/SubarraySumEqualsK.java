package com.leetcode;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
//        int[] nums = {1, 2, 3};
//        int k = 3;
//        int[] nums = {1, -1, 0};
//        int k = 0;

        int result = subarraySum(nums, k);
        System.out.println(result);
    }

    public static int subarraySum(int[] nums, int k) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) { // 이전 어떤 부분 배열의 합에서 현재까지 구간합이 k인 경우
                cnt += map.get(sum - k);    // cnt 증가
            }

            int val = map.getOrDefault(sum, 0)+1;
            map.put(sum, val); // 현재 누적합을 맵에 저장
        }

        return cnt;
    }
}
