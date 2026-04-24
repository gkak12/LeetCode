package code.kotlin

fun main(){
    val nums = intArrayOf(1,2,3,4)
    val result = productExceptSelf(nums)

    println(result)
}

fun productExceptSelf(nums: IntArray): IntArray {
    val len = nums.size
    val result = IntArray(len)

    var zeroCnt = 0
    var total = 1;

    for(i in 0 until len) {
        if(nums[i] == 0) {
            zeroCnt++
        } else {
            total *= nums[i]
        }
    }

    if(zeroCnt > 1) {
        return result
    }

    for(i in 0 until len) {
        if(nums[i] == 0) {
            result[i] = total
        } else {
            result[i] = if(zeroCnt == 1) 0 else total/nums[i]
        }
    }

    return result
}