package code.java;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.*;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        String s = "the sky is blue";
//        String s = "  hello world  ";
//        String s = "a good   example";

        String result = reverseWords(s);
        System.out.println(result);
    }

    public static String reverseWords(String s) {
        List<String> words = Arrays.asList(s.trim().split("\\s+")); // 공백 기준으로 문자열 리스트 생성
        Collections.reverse(words); // 리스트 현재 순서 반대로 뒤집기

        return String.join(" ", words); // 리스트 요소 사이에 공백 추가한 뒤 리턴
    }
}
