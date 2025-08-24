package code.kotlin

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    // val cost = intArrayOf(10, 15, 20)
    val cost = intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)

    val result = minCostClimbingStairs(cost)
    println(result)
}

fun minCostClimbingStairs(cost: IntArray): Int {
    val len = cost.size

    if (len == 2) {  // length가 2인 경우
        return minOf(cost[0], cost[1])
    }

    for (i in 1 until cost.size) {
        val val1 = cost[i] + if (i - 2 >= 0) cost[i - 2] else 0
        val val2 = cost[i] + if (i - 1 >= 0) cost[i - 1] else 0

        cost[i] = minOf(val1, val2)  // 최소 비용 계단 비용을 현재 계단 비용으로 갱신
    }

    return minOf(cost[len - 2], cost[len - 1])  // 2칸 전의 계단 비용과 1칸 전의 계단 비용 중에서 최소비용 리턴
}