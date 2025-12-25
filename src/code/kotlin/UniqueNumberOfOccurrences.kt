package code.kotlin

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/submissions/1865017737/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
//    val arr = intArrayOf(1,2,2,1,1,3)
//    val arr = intArrayOf(1,2)
    val arr = intArrayOf(-3,0,1,-3,1,1,1,-3,10,0)
    val result = uniqueOccurrences(arr)

    println(result)
}

fun uniqueOccurrences(arr: IntArray): Boolean {
    val map = mutableMapOf<Int,Int>()   // 숫자별 개수 저장하는 Map

    for(i in 0 until arr.size){     // 숫자별 개수 카운트
        val num = arr.get(i)
        val cnt = map.getOrDefault(num, 0) + 1
        map[num] = cnt
    }

    val result = if (map.keys.size == map.values.toSet().size) {    // 숫자 종류 개수와 숫자별 개수가 같은 경우 true 리턴
        true
    } else {    // 그렇지 않은 경우 false 리턴
        false
    }

    return result
}