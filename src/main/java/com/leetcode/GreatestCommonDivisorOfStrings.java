package com.leetcode;

public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
//        String str1 = "ABCABC";
//        String str2 = "ABC";
//        String str1 = "ABABAB";
//        String str2 = "ABAB";
        String str1 = "LEET";
        String str2 = "CODE";

        String res = gcdOfStrings(str1, str2);
        System.out.println("res: "+res);
    }

    public static String gcdOfStrings(String str1, String str2) {
        if(str1.equals(str2)){  // 두 문자열이 같은 경우
            return str1;
        }

        if(!str1.concat(str2).equals(str2.concat(str1))){   // 두 문자열을 서로 더해서 같지 않으면 빈 문자열 리턴
            return "";
        }

        int num1 = Math.max(str1.length(), str2.length());
        int num2 = Math.min(str1.length(), str2.length());
        int gcd = getGcd(num1, num2);           // 최대 공약수 조회
        String strGcd = str1.substring(0, gcd); // 공통 문자열

        return strGcd;
    }

    public static int getGcd(int num1, int num2){   // 유클리드 알고리즘 사용해서 최대공약수 조회
        while(num2 != 0){
            int tmp = num2;
            num2 = num1 % num2;
            num1 = tmp;
        }

        return num1;
    }
}
