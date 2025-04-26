package com.leetcode;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1};
//        int k = 2;
//        int[] nums = {1, 2, 3};
//        int k = 3;
        int[] nums = {1, -1, 0};
        int k = 0;

        int result = subarraySum(nums, k);
        System.out.println(result);
    }

    public static int subarraySum(int[] nums, int k) {
        int cnt = 0;

        for(int i = 0 ; i < nums.length ; i++){
            int num = nums[i];

            if(num == k){
                cnt++;
            }

            for(int j = i+1 ; j < nums.length ; j++){
                num += nums[j];

                if(num == k){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
