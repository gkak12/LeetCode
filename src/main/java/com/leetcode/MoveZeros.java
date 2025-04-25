package com.leetcode;

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
            if(nums[idx] != 0) {
                int temp = nums[zeroIdx];
                nums[zeroIdx] = nums[idx];
                nums[idx] = temp;

                zeroIdx += 1;
            }

            idx++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
