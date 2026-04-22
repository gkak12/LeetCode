package code.kotlin

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/submissions/1624093269/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    val nums1 = intArrayOf(1, 2, 3)
    val nums2 = intArrayOf(2, 4, 6)

    val result = findDifference(nums1, nums2)
    println(result)
}

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val set1 = nums1.toSet()    // 배열 -> set 저장
    val set2 = nums2.toSet()    // 배열 -> set 저장

    val common = set1.intersect(set2)   // 중복되는 숫자 저장하는 set

    val uniqueToNums1 = set1.filterNot { it in common }     // set1에서 중복되는 숫자 제외하고 리스트 변환
    val uniqueToNums2 = set2.filterNot { it in common }     // set2에서 중복되는 숫자 제외하고 리스트 변환

    return listOf(uniqueToNums1, uniqueToNums2)
}