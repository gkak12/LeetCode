package code.java;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1290036073/
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);

        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();   // 부분 문자열 저장하는 Set
        int leftIdx = 0;    // 왼쪽 인덱스
        int rightIdx = 0;   // 오른쪽 인덱스
        int maxLen = 0;     // 부분 문자열 최대 길이

        while(rightIdx < s.length()) {  // 오른쪽 인덱스가 문자열 길이보다 작으면 루프 실행
            char curr = s.charAt(rightIdx); // 오른쪽 인덱스 현재 문자

            while(set.contains(curr)) { // Set에 현재 문자가 있으면 루프 실행
                set.remove(s.charAt(leftIdx));  // Set에서 현재 문자 삭제
                leftIdx++;  // 왼쪽 인덱스 증가
            }

            set.add(curr);  // Set에 현재 문자 추가
            maxLen = Math.max(maxLen, rightIdx-leftIdx+1);  // 부분 문자열 최대 길이 갱신
            rightIdx++; // 오른쪽 인덱스 증가
        }

        return maxLen;  // 부분 문자열 최대 길이 리턴
    }

//    public static int lengthOfLongestSubstring(String s) {
//        int prev = 0;
//        int idx = 0;
//        int max = 0;
//        Set<Character> set = new HashSet<>();
//
//        while(idx < s.length()) {
//            char curr = s.charAt(idx);
//
//            if(!set.contains(curr)) {
//                set.add(curr);
//                idx++;
//                max = Math.max(max, set.size());
//            } else {
//                set.remove(s.charAt(prev));
//                prev++;
//            }
//        }
//
//        return max;
//    }
}
