package code.java;

/**
 * https://leetcode.com/problems/unique-paths/description/?envType=study-plan-v2&envId=leetcode-75
 */

public class UniquePaths {

    public static void main(String[] args) {
        int m = 3, n = 7;
//        int m = 3, n = 2;

        int result = uniquePaths(m, n);
        System.out.println(result);
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // 첫번째 행 또는 첫번째 열인 경우
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
