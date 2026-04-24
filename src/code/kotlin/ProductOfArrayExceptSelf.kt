package code.kotlin

/**
 *  https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
    val nums = intArrayOf(1,2,3,4)
    val result = productExceptSelf(nums)
//    val nums = intArrayOf(-1,1,0,-3,3)
//    val result = productExceptSelf(nums)
//    val nums = intArrayOf(0,0)
//    val result = productExceptSelf(nums)
//    val nums = intArrayOf(0,4,0)
//    val result = productExceptSelf(nums)

    println(result)
}

fun productExceptSelf(nums: IntArray): IntArray {
    val len = nums.size
    val result = IntArray(len)

    var zeroCnt = 0     // 전체 0 개수
    var total = 1;      // 전체 곱셈값

    for(i in 0 until len) {
        if(nums[i] == 0) {  // 전체 0 개수 카운트
            zeroCnt++
        } else {    // 0이 아닌 경우 전체 곱셈값 갱신
            total *= nums[i]
        }
    }

    if(zeroCnt > 1) {   // 전체 0 개수가 1 초과인 경우(2개 이상인 경우)
        return result   // 전체 값이 0인 배열 리턴
    }

    for(i in 0 until len) {
        if(nums[i] == 0) {      // 현재 배열 요소 값이 0인 경우
            result[i] = total   // 전체 곱셈값 반영
        } else {    // 현재 배열 요소 값이 0이 아닌 경우
            result[i] = if(zeroCnt == 1) 0 else total/nums[i]   // 전체 0 개수가 1이면 0 반영 아니면 전체 곱셈값에서 자기 자신 나눈 값 반영
        }
    }

    return result
}