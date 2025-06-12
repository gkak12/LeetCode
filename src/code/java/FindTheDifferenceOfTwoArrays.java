package code.java;

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/submissions/1624093269/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.*;

public class FindTheDifferenceOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};

        List<List<Integer>> result = findDifference(nums1, nums2);
        System.out.println(result);
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Integer[] boxedArr1 = Arrays.stream(nums1).boxed().toArray(Integer[]::new);     // 배열 -> set 저장
        Set<Integer> set1 = new HashSet<>(Arrays.asList(boxedArr1));

        Integer[] boxedArr2 = Arrays.stream(nums2).boxed().toArray(Integer[]::new);     // 배열 -> set 저장
        Set<Integer> set2 = new HashSet<>(Arrays.asList(boxedArr2));

        Set<Integer> common = new HashSet<>();  // 중복되는 숫자 저장하는 set

        for(int s1 : set1){
            if(set2.contains(s1)){  // 중복되는 숫자 저장
                common.add(s1);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(set1.stream().filter(item -> !common.contains(item)).toList());  // set1에서 중복되는 숫자 제외하고 리스트 변환
        result.add(set2.stream().filter(item -> !common.contains(item)).toList());  // set2에서 중복되는 숫자 제외하고 리스트 변환

        return result;
    }
}
