package code.java;

/**
 * https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){ // n이 0인 경우 종료
            return;
        }

        int idx1 = m;   // nums1 인덱스
        int idx2 = 0;   // nums2 인덱스

        while(idx2 < n){    // idx2가 n보다 작은 경우 루프 실행
            nums1[idx1] = nums2[idx2];  // nums1에 nums2 추가

            idx1++; // idx1 증가
            idx2++; // idx2 증가
        }

        Arrays.sort(nums1); // nums1 정렬
    }
}
