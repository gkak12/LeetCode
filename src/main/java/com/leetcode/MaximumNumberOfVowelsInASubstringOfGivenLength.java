package com.leetcode;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/1617254917/?envType=study-plan-v2&envId=leetcode-75
 */

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;

        int result = maxVowels(s, k);
        System.out.println(result);
    }

    public static int maxVowels(String s, int k) {
        int cnt = 0;

        for(int i = 0 ; i < k ; i++){   // 초기 모음 갯수 계산
            char c = s.charAt(i);

            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt++;
            }
        }

        int maxCnt = cnt;   // 초기 모음 갯수를 최대 모음 갯수로 설정

        for(int i = k ; i < s.length() ; i++){  // 배열 확장하면서 최대 모음 갯수 갱신
            char beforeC = s.charAt(i-k);   // 이전 요소
            char currC = s.charAt(i);       // 현재 요소

            if(beforeC == 'a' || beforeC == 'e' || beforeC == 'i' || beforeC == 'o' || beforeC == 'u') {    // 이전 요소가 모음이면 갯수 1개 감소
                cnt--;
            }

            if(currC == 'a' || currC == 'e' || currC == 'i' || currC == 'o' || currC == 'u') {  // 현재 요소가 모음이면 갯수 1개 증가
                cnt++;
            }

            maxCnt = Math.max(maxCnt, cnt); // 최대 모음 갯수 갱신
        }

        return maxCnt;
    }
}
