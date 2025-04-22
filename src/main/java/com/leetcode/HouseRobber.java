package com.leetcode;

/**
 * https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
//        int[] nums = {2,7,9,3,1};
//        int[] nums = {3,2,1,5,0,2};
//        int[] nums = {2,3,1,1,1,5,1};
        int[] nums = {3,5,0,0,0,0};

        int result = rob(nums);
        System.out.println(result);
    }

    public static int rob(int[] nums) {
        int len = nums.length;

        if(len < 3){    // 배열 길이가 3 미만인 경우
            return Arrays.stream(nums).max().getAsInt();    // 가장 큰 비용 리턴
        }

        for(int i = 2 ; i < len ; i++){
            int val1 = nums[i];
            int val2 = nums[i];

            if(i-3 >= 0) val1 += nums[i-3]; // 앞의 3칸 집 비용과 현재 집 비용 더하기
            if(i-2 >= 0) val2 += nums[i-2]; // 앞의 2칸 집 비용과 현재 집 비용 더하기

            nums[i] = Math.max(val1, val2); // 2개 중에서 큰 비용으로 현재 집 비용 갱신
        }

        return Arrays.stream(nums).max().getAsInt();    // 가장 큰 비용 리턴
    }
}
