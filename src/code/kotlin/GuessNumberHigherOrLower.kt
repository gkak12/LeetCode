package code.kotlin

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
    val n = 1000
    val result = guessNumber(n)
    println(result)
}

fun guess(num: Int): Int {
    val pick = 50

    return when {
        num > pick -> -1  // 추측한 숫자가 큼
        num < pick -> 1   // 추측한 숫자가 작음
        else -> 0         // 정답
    }
}

fun guessNumber(n: Int): Int {
    var min: Long = 1
    var max: Long = n.toLong()

    while (true) {
        val num = (min + max) / 2
        val flag = guess(num.toInt())

        when {
            flag < 0 -> max = num - 1  // 추측한 숫자가 큼 -> 범위를 줄임
            flag > 0 -> min = num + 1  // 추측한 숫자가 작음 -> 범위를 늘림
            else -> return num.toInt() // 정답
        }
    }
}