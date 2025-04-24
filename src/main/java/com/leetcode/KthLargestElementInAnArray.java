package com.leetcode;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/1616787103/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
//        int[] nums = {3,2,3,1,2,4,5,5,6};
//        int k = 4;

        int result = findKthLargest(nums, k);
        System.out.println(result);
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    // 우선순위 큐 객체 생성(오름차순 정렬 기준)
        Arrays.stream(nums).forEach(num -> pq.offer(num));  // 배열을 우선순위 큐에 저장

        while(k > 1){   // k순위 보다 위에 있는 숫자 우선순위 큐에서 삭제
            pq.poll();
            k--;
        }

        return pq.peek();   // k순위 숫자 리턴
    }
}
