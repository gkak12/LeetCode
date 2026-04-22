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
        int leftIdx = 0;
        int rightIdx = s.length()-1;

        while(leftIdx < rightIdx) {
            Character leftC = s.charAt(leftIdx);    // 왼쪽 문자
            Character rightC = s.charAt(rightIdx);  // 오른쪽 문자

            if(!Character.isLetterOrDigit(leftC)) { // 왼쪽 문자가 영문자나 숫자 아닌 경우
                leftIdx++;  // 왼쪽 인덱스 증가
            } else if(!Character.isLetterOrDigit(rightC)) { // 오른쪽 문자가 영문자나 숫자 아닌 경우
                rightIdx--; // 오른쪽 인덱스 감소
            } else {    // 왼쪽 문자와 오른쪽 문자가 염문자나 숫자인 경우
                if(Character.toLowerCase(leftC) != Character.toLowerCase(rightC)) { // 왼쪽 문자와 오른쪽 문자를 소문자로 변환한 뒤 비교해서 다른 경우
                    return false;   // false 리턴
                }

                leftIdx++;  // 왼쪽 인덱스 증가
                rightIdx--; // 오른쪽 인덱스 증가
            }
        }

        return true;
    }
}
