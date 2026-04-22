package code.kotlin

import java.util.*

fun main() {
    val nums = intArrayOf(1, 2, 3)
    val result = permute(nums)
    println(result)
}

fun permute(nums: IntArray): List<List<Int>> {
    val resList = mutableListOf<List<Int>>()

    search(nums, mutableListOf(), resList)

    return resList
}

fun search(
    nums: IntArray,
    currentPath: MutableList<Int>,
    resList: MutableList<List<Int>>
) {
    // 모든 숫자를 선택한 경우 (Base Case)
    if (currentPath.size == nums.size) {
        resList.add(ArrayList(currentPath)) // Deep copy
        return
    }

    for (num in nums) {
        // 현재 숫자가 경로에 포함되어 있지 않은 경우
        if (!currentPath.contains(num)) {
            currentPath.add(num)           // 숫자 추가 (Push 개념)
            search(nums, currentPath, resList) // 재귀 호출
            currentPath.removeAt(currentPath.size - 1) // 마지막 숫자 제거 (Pop 개념)
        }
    }
}