package code.kotlin

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
//    val nums = intArrayOf(1,2,3,4,5)
//    val nums = intArrayOf(5,4,3,2,1)
//    val nums = intArrayOf(2,1,5,0,4,6)
    val nums = intArrayOf(1,5,0,4,1,3)

    val result = increasingTriplet(nums)
    println(result)
}

fun increasingTriplet(nums: IntArray): Boolean {
    var first = Int.MAX_VALUE
    var second = Int.MAX_VALUE

    for(n in nums){
        if(n <= first){     // 현재 숫자가 가장 작으면 first 업데이트
            first = n
        } else if(n <= second){     // 현재 숫자가 first보다는 크고 second보다 작거나 같으면 second 업데이트
            second = n
        } else {    // 현재 숫자가 first와 second보다 크면 리턴(3개 찾았기 때문에)
            return true
        }
    }

    return false
}