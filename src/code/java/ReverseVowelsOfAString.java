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

        Set<Character> set = new HashSet<>(Arrays.asList(
            'a', 'e', 'i', 'o', 'u'
            , 'A', 'E', 'I', 'O', 'U'
        ));

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);

            if(set.contains(c)) {
                sb.append(asterisk);
                stack.push(c);
            } else {
                sb.append(c);
            }
        }

        for(int i = 0 ; i < sb.length() ; i++) {
            char c = sb.charAt(i);

            if(c == asterisk){
                char vowel = stack.pop();
                sb.setCharAt(i, vowel);
            }
        }

        String answer = sb.toString();
        return answer;
    }
}
