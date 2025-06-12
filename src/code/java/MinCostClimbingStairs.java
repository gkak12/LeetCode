package code.java;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=leetcode-75
 */

public class MinCostClimbingStairs {
    public static void main(String[] args) {
//        int[] cost = {10,15,20};
        int[] cost = {1,100,1,1,1,100,1,1,100,1};

        int result = minCostClimbingStairs(cost);
        System.out.println(result);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;

        if(len == 2){   // length가 2인 경우
            return Math.min(cost[0], cost[1]);
        }

        for(int i = 1; i < cost.length; i++){
            int val1 = cost[i];
            int val2 = cost[i];

            if(i-2 >= 0) val1 += cost[i-2]; // 2칸 전의 계단 비용과 현재 계단 비용 더하기
            if(i-1 >= 0) val2 += cost[i-1]; // 1칸 전의 계단 비용과 현재 계단 비용 더하기

            cost[i] = Math.min(val1, val2); // 최소 비용 계단 비용을 현재 계단 비용으로 갱신 
        }

        return Math.min(cost[len-2], cost[len-1]);  // 2칸 전의 계단 비용과 1칸 전의 계단 비용 중에서 최소비용 리턴
    }
}
