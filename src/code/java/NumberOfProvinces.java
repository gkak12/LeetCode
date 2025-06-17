package code.java;

/**
 * https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.Stack;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

//        int[][] isConnected = {
//            {1, 0, 1, 0},
//            {0, 1, 0, 1},
//            {1, 0, 1, 0},
//            {0, 1, 0, 1}
//        };

//        int[][] isConnected = {
//            {1, 1, 1, 0},
//            {1, 1, 1, 0},
//            {1, 1, 1, 0},
//            {0, 0, 0, 1}
//        };

//        int[][] isConnected = {
//            {1, 1, 1, 0},
//            {1, 1, 0, 0},
//            {1, 0, 1, 1},
//            {0, 0, 1, 1}
//        };

//        int[][] isConnected = {
//            {1, 0, 0, 0, 0},
//            {0, 1, 1, 0, 0},
//            {0, 1, 1, 1, 0},
//            {0, 0, 1, 1, 0},
//            {0, 0, 0, 0, 1}
//        };

        int result = findCircleNum(isConnected);
        System.out.println(result);
    }

    public static int findCircleNum(int[][] isConnected) {
        int result = 0;
        int len = isConnected.length;
        boolean[] visitLog = new boolean[len];

        for(int i = 0; i < len; i++) {
            if(!visitLog[i]) {
                search(i, isConnected, visitLog);
                result++;
            }
        }

        return result;
    }

    public static void search(int num, int[][] isConnected, boolean[] visitLog) {
        int len = isConnected.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(num);
        visitLog[num] = true;

        while(!stack.isEmpty()) {
            int i = stack.pop();

            for(int j = 0; j < len; j++) {
                if(isConnected[i][j] == 1 && !visitLog[j]) {
                    stack.push(j);
                    visitLog[j] = true;
                }
            }
        }
    }
}
