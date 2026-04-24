package code.java;

/**
 *  https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = productExceptSelf(nums);
//        int[] nums = {-1,1,0,-3,3};
//        int[] result = productExceptSelf(nums);
//        int[] nums = {0,0};
//        int[] result = productExceptSelf(nums);
//        int[] nums = {0,4,0};
//        int[] result = productExceptSelf(nums);

        System.out.println(Arrays.toString(result));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        int zeroCnt = 0;    // 전체 0 개수
        int total = 1;      // 전체 곱셈값

        for(int i = 0; i < len; i++) {
            if(nums[i] == 0) {   // 전체 0 개수 카운트
                zeroCnt++;
            } else {    // 0이 아닌 경우 전체 곱셈값 갱신
                total *= nums[i];
            }
        }

        if(zeroCnt > 1) {   // 전체 0 개수가 1 초과인 경우(2개 이상인 경우)
            return result;  // 전체 값이 0인 배열 리턴
        }

        for(int i = 0; i < len; i++) {
            if(nums[i] == 0) {  // 현재 배열 요소 값이 0인 경우
                result[i] = total;  // 전체 곱셈값 반영
            } else {    // 현재 배열 요소 값이 0이 아닌 경우
                result[i] = zeroCnt == 1 ? 0 : total/nums[i];   // 전체 0 개수가 1이면 0 반영 아니면 전체 곱셈값에서 자기 자신 나눈 값 반영
            }
        }

        return result;
    }
}
