package code.java;

/**
 * https://leetcode.com/problems/valid-palindrome/submissions/1873313934/?envType=study-plan-v2&envId=top-interview-150
 */

public class ValidPalindrome {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
//        String s = " ";
        String s = "0P";

        boolean result = isPalindrome(s);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();    // 영문자와 숫자를 제외한 나머지 문자를 제거하고 소문자 처리
        StringBuilder sb = new StringBuilder(str);  // 처리한 문자열을 StringBuilder 객체로 생성
        String rStr = sb.reverse().toString();      // sb 순서 뒤집고 문자열 반환

        return str.equals(rStr);    // 두 문자열 같은지 비교
    }
}
