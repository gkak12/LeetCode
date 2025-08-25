package code.kotlin

/**
 * https://leetcode.com/problems/equal-row-and-column-pairs/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    val grid = arrayOf(
        intArrayOf(3, 2, 1),
        intArrayOf(1, 7, 6),
        intArrayOf(2, 7, 7)
    )
//    val grid = arrayOf(
//        intArrayOf(3, 1, 2, 2),
//        intArrayOf(1, 4, 4, 5),
//        intArrayOf(2, 4, 2, 2),
//        intArrayOf(2, 4, 2, 2)
//    )

    val result = equalPairs(grid)
    println(result)
}

fun equalPairs(grid: Array<IntArray>): Int {
    val map = mutableMapOf<String, Int>()

    for (row in grid) {     // row map에 저장
        val key = row.contentToString()
        map[key] = map.getOrDefault(key, 0) + 1
    }

    var count = 0

    for (j in grid[0].indices) {    // col 조회하면서 map에 있는 row 카운트
        val col = IntArray(grid.size) { i -> grid[i][j] }
        val key = col.contentToString()
        count += map.getOrDefault(key, 0)
    }

    return count
}