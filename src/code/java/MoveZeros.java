package code.java;

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
        int zeroIdx = 0;    // 0 인덱스
        int idx = 0;        // 정수 인덱스

        while(idx < nums.length) {
            // 회전 돌 때마다 가장 앞에 있는 0 인덱스 조회
            if(nums[zeroIdx] != 0){
                zeroIdx++;
            }

            // 0 인덱스가 정수 인덱스보다 작고, 0 인덱스 원소가 0이고, 정수 인덱스 원소가 정수인 경우 교환 실행
            if(zeroIdx < idx && nums[zeroIdx] == 0 && nums[idx] != 0) {
                int tmp = nums[idx];
                nums[idx] = nums[zeroIdx];
                nums[zeroIdx] = tmp;
            }

            idx++;
        }

        System.out.println(Arrays.toString(nums));
    }

//    public static void moveZeroes(int[] nums) {
//        int zeroIdx = 0;
//        int idx = 0;
//
//        while(idx < nums.length) {
//            if(nums[idx] != 0) {    // 0이 아닌 경우 교환 수행
//                int temp = nums[zeroIdx];
//                nums[zeroIdx] = nums[idx];
//                nums[idx] = temp;
//
//                zeroIdx += 1;   // 0이 있는 인덱스 1 증가
//            }
//
//            idx++;
//        }
//
//        System.out.println(Arrays.toString(nums));
//    }
}
