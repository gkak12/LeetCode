package code.java;

/**
 * https://leetcode.com/problems/combination-sum-iii/submissions/1615555530/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
//        int k = 3;
//        int n = 9;

        List<List<Integer>> result = combinationSum3(k, n);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 1 ; i < 10 ; i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);

            search(k, n, list, result); // 탐색 수행
        }

        return result;
    }

    public static void search(int k, int n, List<Integer> list, List<List<Integer>> result){
        int sum = list.stream().mapToInt(Integer::intValue).sum();

        if(sum == n && list.size() == k) {      // 모든 조건에 만족하는 경우
            result.add(new ArrayList<>(list));  // 현재 리스트 result에 추가
            return;
        }

        if(list.size() == k) {   // 모든 조건에 만족하지 않고, 이미 탐색을 마친 경우
            return;
        }

        int startNum = list.getLast();   // 리스트의 마지막 숫자를 시작 숫자로 설정

        for(int i = startNum ; i < 10 ; i++){
            if(!list.contains(i) && list.size() < k && sum+i <= n){ // 다음 숫자가 중복되지 않았고, 리스트 사이즈가 k 보다 작고, 다음 숫자를 더한 값이 n 보다 작은 경우
                list.add(i);                        // 다음 숫자 추가
                search(k, n, list, result);         // 탐색 수행
                list.removeLast();                  // 추가한 숫자 제거(백트래킹 수행)
            }
        }
    }
}
