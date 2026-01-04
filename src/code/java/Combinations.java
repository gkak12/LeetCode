package code.java;

/**
 * https://leetcode.com/problems/combinations/description/?envType=study-plan-v2&envId=top-interview-150
 */

import java.util.*;

public class Combinations {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
//        int n = 1;
//        int k = 1;
//        int n = 5;
//        int k = 2;

        List<List<Integer>> result = combine(n, k);
        System.out.println(result);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        search(1, 0, n, k, new ArrayList<>(), resList);

        return resList;
    }

    public static void search(int num, int depth, int n, int k, List<Integer> curr, List<List<Integer>> list){
        if(k == depth){     // 모든 숫자를 선택한 경우
            list.add(new ArrayList<>(curr));    // 현재 선택한 숫자 추가, deep copy
            return; // 재귀 호출 종료
        }

        for(int i = num ; i <= n ; i++){    // 숫자 탐색
            curr.add(i);    // 현재 숫자 추가
            search(i+1, depth+1, n, k, curr, list); // 현재 다음 숫자 탐색, 재귀 호출
            curr.removeLast();  // 마지막에 추가한 현재 숫자 삭제
        }
    }
}
