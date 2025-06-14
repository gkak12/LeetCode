package code.kotlin

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/submissions/1617218933/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
//    val nums = intArrayOf(1, 12, -5, -6, 50, 3)
//    val k = 4
//    val nums = intArrayOf(5)
//    val k = 1
//    val nums = intArrayOf(0, 4, 0, 3, 2)
//    val k = 1
    val nums = intArrayOf(4, 0, 4, 3, 3)
    val k = 5

    val result = findMaxAverage(nums, k)
    println(result)
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var sum = 0.0

    for(i in 0 until k){    // 초기 sum 계산
        sum += nums[i]
    }

    var max = sum   // 초기 sum을 max로 설정

    for(i in k until nums.size){    // 배열 확장하면서 sum 갱신
        sum = sum - nums[i-k] + nums[i]     // 이전 요소 빼고 현재 요소 더해서 sum 갱신
        max = maxOf(max, sum)   // max과 sum 비교하면서 갱신
    }

    val result = max/k  // 평균값
    return result
}