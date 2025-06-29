package code.java;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.*;

public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        String s = "IceCreAm";
//        String s = "leetcode";

        String result = reverseVowels(s);
        System.out.println(result);
    }

    public static String reverseVowels(String s) {
        char asterisk = '*';

        Set<Character> set = Set.of(    // 모음 Set
            'a', 'e', 'i', 'o', 'u'
            , 'A', 'E', 'I', 'O', 'U'
        );

        Stack<Character> stack = new Stack<>(); // 뒤집는 연산 대신 스택 사용
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);

            if(set.contains(c)) {   // 모음인 경우
                sb.append(asterisk);    // sb에 모음 대신 * 추가
                stack.push(c);          // 스택에 모음 추가
            } else {    // 자음인 경우
                sb.append(c);   // sb에 자음 추가
            }
        }

        for(int i = 0 ; i < sb.length() ; i++) {
            char c = sb.charAt(i);

            if(c == asterisk){  // *인 경우
                char vowel = stack.pop();   // 스택에서 모음 추출
                sb.setCharAt(i, vowel);     // * 대신에 모음 추가
            }
        }

        String answer = sb.toString();
        return answer;
    }
}
