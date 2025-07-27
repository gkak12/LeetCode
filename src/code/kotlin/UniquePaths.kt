package code.kotlin

/**
 * https://leetcode.com/problems/unique-paths/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
    val m = 3
    val n = 7

//    val m = 3
//    val n = 2

    val result = uniquePaths(m,n)
    println(result)
}

fun uniquePaths(m: Int, n: Int): Int{
    val dp = Array(m){IntArray(n)}

    for(i in 0 until m){
        for(j in 0 until n){
            // 첫번째 행 또는 첫번째 열인 경우
            if(i == 0 || j == 0){
                dp[i][j] = 1
                continue
            }

            dp[i][j] = dp[i-1][j] + dp[i][j-1]
        }
    }

    return dp[m-1][n-1]
}