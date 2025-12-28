package code.java;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/submissions/1865017737/?envType=study-plan-v2&envId=leetcode-75
 */

public class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
//        int[] arr = {1,2};
//        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};

        boolean result = uniqueOccurrences(arr);
        System.out.println(result);
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();    // 숫자별 개수 저장하는 Map

        for(int num : arr){     // 숫자별 개수 count
            int cnt = map.getOrDefault(num, 0) + 1;
            map.put(num, cnt);
        }

        long setSize = map.values().stream().distinct().count();    // Map의 Value인 숫자별 개수를 중복 제거하고 Size 조회
        int keySize = map.keySet().size();  // Map의 Key인 숫자 종류 개수 Size 조회

        boolean result = setSize == keySize;    // setSize와 keySize가 같은 경우 true 리턴, 그렇지 않으면 false 리턴
        return result;
    }
}
