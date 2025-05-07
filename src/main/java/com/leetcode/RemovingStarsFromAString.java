package com.leetcode;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string/submissions/1627793977/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.Stack;

public class RemovingStarsFromAString {

    public static void main(String[] args) {
        String s = "leet**cod*e";
//        String s = "erase*****";

        String result = removeStars(s);
        System.out.println(result);
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();         // 문자열 저장하는 stack
        Stack<Character> otherStack = new Stack<>();    // '*' 저장하는 otherStack

        for(Character c : s.toCharArray()){     // 문자열 s를 stack에 저장
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){    // 문자열 탐색
            Character curr = stack.pop();   // 현재 문자

            if(curr == '*'){    // 현재 문자가 '*'인 경우
                otherStack.push(curr);  // otherStack에 '*' 저장
                continue;
            }

            if(curr != '*' && !otherStack.isEmpty()) {  // 현재 문자가 '*'이 아니고, otherStack이 비어있지 않은 경우
                otherStack.pop();   // otherStack pop 처리
                continue;
            }

            sb.append(curr);    // 문자 StringBuilder에 추가
        }

        return sb.reverse().toString();     // 문자가 거꾸로 저장되어 있으므로 reverse 처리해서 리턴
    }
}
