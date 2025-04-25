package com.leetcode;

/**
 * https://leetcode.com/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {0};
//        int[] nums = {1, 0, 1};
        int[] nums = {1, 2, 3, 0, 5, 0, 0};

        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int zeroIdx = 0;
        int idx = 0;

        while(idx < nums.length) {
            if(nums[idx] != 0) {    // 0이 아닌 경우 교환 수행
                int temp = nums[zeroIdx];
                nums[zeroIdx] = nums[idx];
                nums[idx] = temp;

                zeroIdx += 1;   // 0이 있는 인덱스 1 증가
            }

            idx++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
