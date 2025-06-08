package com.leetcode;

public class FindPivotIndex {

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
//        int[] nums = {1,2,3};
//        int[] nums = {2,1,-1};

        int result = pivotIndex(nums);
        System.out.println(result);
    }

    public static int pivotIndex(int[] nums) {
        int pivot = -1;
        int[] prefix = new int[nums.length+1];

        /**
         * 누적합 배열 초기화
         * pivot이 0인 경우 왼쪽 배열의 합은 0이기 때문에
         * 누적합 인덱스 0의 값은 0이고, 인덱스 1부터 초기화
         */
        for(int idx = 1; idx < prefix.length ; idx++){
            prefix[idx] = prefix[idx-1] + nums[idx-1];
        }

        int lastIdx = prefix.length-1;  // 누적합 마지막 인덱스

        /**
         * pivot 인덱스 탐색
         * pivot 인덱스를 제외한 왼쪽 배열의 함과 오른쪽 배열의 합이 같아야 함
         * 마지막 인덱스 전까지 탐색, 마지막 인덱스까지 탐색하는 것은 의미 없음
         */
        for(int idx = 0 ; idx < lastIdx ; idx++){
            int left = prefix[idx];
            int right = prefix[lastIdx] - prefix[idx+1];

            if(left == right){  // 왼쪽 배열의 합과 오른쪽 배열의 합이 같은 경우
                return idx;
            }
        }

        return pivot;
    }
}
