package code.kotlin

/**
 * https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
//    val nums = intArrayOf(1, 2, 3, 1)
//    val nums = intArrayOf(2, 7, 9, 3, 1)
//    val nums = intArrayOf(3, 2, 1, 5, 0, 2)
//    val nums = intArrayOf(2, 3, 1, 1, 1, 5, 1)
    val nums = intArrayOf(3, 5, 0, 0, 0, 0)

    val result = rob(nums)
    println(result)
}

fun rob(nums: IntArray): Int {
    val len = nums.size

    if (len < 3) {  // 배열 길이가 3 미만인 경우
        return nums.maxOrNull() ?: 0    // 가장 큰 비용 리턴
    }

    for (i in 2 until len) {
        var val1 = nums[i]
        var val2 = nums[i]

        if (i - 3 >= 0) val1 += nums[i-3]   // 앞의 3칸 집 비용과 현재 집 비용 더하기
        if (i - 2 >= 0) val2 += nums[i-2]   // 앞의 2칸 집 비용과 현재 집 비용 더하기

        nums[i] = maxOf(val1, val2)     // 2개 중에서 큰 비용으로 현재 집 비용 갱신
    }

    return nums.maxOrNull() ?: 0    // 가장 큰 비용 리턴
}
