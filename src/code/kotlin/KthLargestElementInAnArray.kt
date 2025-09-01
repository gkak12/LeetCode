package code.kotlin

import java.util.*

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/1616787103/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
    val nums = intArrayOf(3,2,1,5,6,4)
    val k = 2
//    val nums = intArrayOf(3,2,3,1,2,4,5,5,6)
//    val k = 4

    val result = findKthLargest(nums, k)
    println(result)
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    var num = k
    val pq = PriorityQueue<Int>(compareByDescending { it })     // 우선순위 큐 객체 생성(오름차순 정렬 기준)
    nums.forEach { pq.offer(it) }   // 배열을 우선순위 큐에 저장

    while(num > 1){     // k순위 보다 위에 있는 숫자 우선순위 큐에서 삭제
        pq.poll()
        num--
    }

    return pq.peek()    // k순위 숫자 리턴
}