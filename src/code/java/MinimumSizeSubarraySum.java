package code.java;

import java.util.Arrays;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
//        int target = 4;
//        int[] nums = {1,4,4};
//        int target = 11;
//        int[] nums = {1,1,1,1,1,1,1,1};

        int result = minSubArrayLen(target, nums);
        System.out.println(result);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int leftIdx = 0;    // 슬라이딩 윈도우 시작 인덱스, left
        int rightIdx = 0;   // 슬라이딩 윈도우 종료 인덱스, right
        int sum = 0;        // 슬라이딩 윈도우 범위 합계값
        int len = Integer.MAX_VALUE;

        while(leftIdx < nums.length && rightIdx < nums.length) {    // leftIdx와 rightIdx가 배열 길이보다 작은 경우 루프 실행
            sum += nums[rightIdx];  // sum에 rightIdx 값 추가

            while(sum >= target) {  // sum이 target보다 크거나 같은 경우
                len = Math.min(len, rightIdx-leftIdx+1);    // len 갱신
                sum -= nums[leftIdx];   // sum에서 leftIdx 값 삭제
                leftIdx++;              // leftIdx 증가
            }

            rightIdx++; // rightIdx 증가
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
