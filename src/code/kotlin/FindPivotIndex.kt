package code.kotlin

/**
 * https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    val nums = intArrayOf(1, 7, 3, 6, 5, 6)
//    val nums = intArrayOf(1, 2, 3)
//    val nums = intArrayOf(2, 1, -1)

    val result = pivotIndex(nums)
    println(result)
}

fun pivotIndex(nums: IntArray): Int {
    var pivot = -1
    val prefix = IntArray(nums.size + 1)

    /**
     * 누적합 배열 초기화
     * pivot이 0인 경우 왼쪽 배열의 합은 0이기 때문에
     * 누적합 인덱스 0의 값은 0이고, 인덱스 1부터 초기화
     */
    for (idx in 1 until prefix.size) {
        prefix[idx] = prefix[idx - 1] + nums[idx - 1]
    }

    val lastIdx = prefix.size - 1 // 누적합 마지막 인덱스

    /**
     * pivot 인덱스 탐색
     * pivot 인덱스를 제외한 왼쪽 배열의 합과 오른쪽 배열의 합이 같아야 함
     * 마지막 인덱스 전까지 탐색, 마지막 인덱스까지 탐색하는 것은 의미 없음
     */
    for (idx in 0 until lastIdx) {
        val left = prefix[idx]
        val right = prefix[lastIdx] - prefix[idx + 1]

        if (left == right) {  // 왼쪽 배열의 합과 오른쪽 배열의 합이 같은 경우
            return idx
        }
    }

    return pivot
}