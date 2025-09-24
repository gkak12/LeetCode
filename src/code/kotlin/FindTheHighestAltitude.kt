package code.kotlin

/**
 * https://leetcode.com/problems/find-the-highest-altitude/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
    val gain = intArrayOf(-5,1,5,0,-7)
//    val gain = intArrayOf(-4,-3,-2,-1,4,3,2)

    val result = largestAltitude(gain)
    println(result)
}

fun largestAltitude(gain: IntArray): Int{
    var max = 0
    val alt = IntArray(gain.size+1)

    System.arraycopy(gain, 0, alt, 1, gain.size)

    for(i in 1 until alt.size){
        alt[i] += alt[i-1]
        max = maxOf(max, alt[i])
    }

    return max
}