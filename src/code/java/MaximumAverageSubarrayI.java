package code.java;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/submissions/1617218933/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
//        int[] nums = {5};
//        int k = 1;
//        int[] nums = {0,4,0,3,2};
//        int k = 1;

        double result = findMaxAverage(nums, k);
        System.out.println(result);
    }

    public static double findMaxAverage(int[] nums, int k) {
        List<Double> list = new ArrayList<>();
        double sum = 0;

        for(int i = 0 ; i < k ; i++){   // 초기 sum 계산
            sum += nums[i];
        }

        list.add(sum);  // 초기 sum을 리스트에 추가

        for(int i = k ; i < nums.length ; i++){     // 배열 확장하면서 sum 계산
            sum = sum-nums[i-k]+nums[i];    // 이전 요소 빼고 현재 요소 더해서 sum 갱신
            list.add(sum);                  // 갱신한 sum을 리스트에 추가
        }

//        double max = list.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
        double max = Collections.max(list); // 최대값 조회
        double result = max/k;  // 평균값 조회
        return result;
    }
}
