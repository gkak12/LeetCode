package code.java;

/**
 * https://leetcode.com/problems/permutations/description/?envType=study-plan-v2&envId=top-interview-150
 */

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
//        int[] nums = {1,2,3};
//        int[] nums = {0,1};
        int[] nums = {1};
        List<List<Integer>> result = permute(nums);

        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {
        int depth = 0;
        List<List<Integer>> resList = new ArrayList<>();
        search(depth, nums, new ArrayList<>(),resList);

        return resList;
    }

    public static void search(int depth, int[] nums, List<Integer> curr, List<List<Integer>> resList) {
        if(depth == nums.length){   // 모든 숫자를 선택한 경우
            resList.add(new ArrayList<>(curr)); // 현재 선택한 숫자들을 resList에 추가, deep copy
            return;     // 재귀 호출 종료
        }

        for(int i = 0 ; i < nums.length ; i++){ // 숫자 탐색
            if(!curr.contains(nums[i])){    // 현재 숫자가 curr에 없는 경우
                curr.add(nums[i]);  // 현재 숫자 curr에 추가
                search(depth+1, nums, curr, resList);   // 다음 숫자 탐색, 재귀 호출
                curr.removeLast();  // 현재 숫자 curr에서 제거
            }
        }
    }
}
