package com.leetcode;

/**
 * http://leetcode.com/problems/merge-strings-alternately/submissions/1621109252/?envType=study-plan-v2&envId=leetcode-75
 */

public class MergeStringsAlternately {

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
//        String word1 = "ab";
//        String word2 = "pqrs";
//        String word1 = "abcd";
//        String word2 = "pq";

        String result = mergeAlternately(word1, word2);
        System.out.println(result);
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len = word1.length() + word2.length();  // word1, word2 문자열 합친 길이
        int cnt = 0;
        int idx1 = 0;
        int idx2 = 0;

        while(cnt < len){
            if(idx1 < word1.length() && idx2 < word2.length()){            // word1 인덱스와 word2 인덱스 둘다 문자열보다 작으면 동시에 추가
                sb.append(word1.charAt(idx1)).append(word2.charAt(idx2));   // word1, word2 문자 추가

                idx1++; // word1 인덱스 증가
                idx2++; // word2 인덱스 증가
                cnt+=2; // 추가한 문자 2개 증가
            } else if(idx1 < word1.length()){    // word1 인덱스만 문자열보다 작으면 word1만 추가
                sb.append(word1.substring(idx1));   // word1 나머지 문자 추가
                break;
            } else if(idx2 < word2.length()){    // word2 인덱스만 문자열보다 작으면 word2만 추가
                sb.append(word2.substring(idx2));   // word2 나머지 문자 추가
                break;
            }
        }

        return sb.toString();
    }
}
