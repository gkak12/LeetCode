package com.leetcode;

public class GuessNumberHigherOrLower {

    public static void main(String[] args) {
        int n = 1000;

        int result = guessNumber(n);
        System.out.println(result);
    }

    private static int pick = 50;

    public static int guess(int num) {
        if (num > pick) return -1;  // 추측한 숫자가 큼
        if (num < pick) return 1;   // 추측한 숫자가 작음
        return 0;                   // 정답
    }

    public static int guessNumber(int n) {
        long min = 1;
        long max = n;

        while(true){
            Long num = (max+min)/2;
//            int num = min+(max-min)/2;  // int 오버플로우 방지
            int flag = guess(num.intValue());

            if(flag < 0){   // 추측한 숫자가 큰 경우, 작은 숫자 범위로 확장 
                max = num-1;    // 추측한 숫자 경계값에서 제외
            } else if(flag > 0){    // 추측한 숫자가 작은 경우, 큰 숫자 범위로 확장
                min = num+1;    // 추측한 숫자 경계값에서 제외
            } else {    // 추측한 숫자가 일치한 경우
                return num.intValue();
            }
        }
    }
}
