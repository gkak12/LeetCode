package code.java;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1873244329/?envType=study-plan-v2&envId=top-interview-150
 */

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int result = removeDuplicates(nums);
        System.out.println(result);
    }

    public static int removeDuplicates(int[] nums) {
        int idx = 1;    // 배열에서 요소를 변경할 인덱스

        for(int i = 1 ; i < nums.length ; i++){
            int prev = nums[i-1];   // 이전 요소
            int curr = nums[i];     // 현재 요소

            if(prev != curr){   // 이전 요소가 현재 요소와 다른 경우
                nums[idx] = curr;   // idx 인덱스에 현재 요소 값 교체
                idx++;  // idx 1 증가
            }
        }

        return idx;
    }
}
