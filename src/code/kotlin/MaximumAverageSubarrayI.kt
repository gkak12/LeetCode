package code.kotlin

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

    for(i in 0 until k){
        sum += nums[i]
    }

    var max = sum

    for(i in k until nums.size){
        sum = sum - nums[i-k] + nums[i]
        max = maxOf(sum, max)
    }

    val result = max/k
    return result
}