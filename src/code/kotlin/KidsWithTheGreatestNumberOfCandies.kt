package code.kotlin

/**
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
    val candies = intArrayOf(2, 3, 5, 1, 3)
    val extraCandies = 3

//    val candies = intArrayOf(4, 2, 1, 1, 2)
//    val extraCandies = 1

//    val candies = intArrayOf(12, 1, 12)
//    val extraCandies = 10

    val result = kidsWithCandies(candies, extraCandies)
    println(result)
}

fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean>{
    val maxCandy = candies.maxOrNull() ?: 0
    return candies.map{ it+extraCandies >= maxCandy}
}