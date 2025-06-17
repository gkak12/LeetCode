package code.kotlin

/**
 * https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    val isConnected = arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 1)
    )

//    val isConnected = arrayOf(
//        intArrayOf(1, 0, 1, 0),
//        intArrayOf(0, 1, 0, 1),
//        intArrayOf(1, 0, 1, 0),
//        intArrayOf(0, 1, 0, 1)
//    )

//    val isConnected = arrayOf(
//        intArrayOf(1, 1, 1, 0),
//        intArrayOf(1, 1, 1, 0),
//        intArrayOf(1, 1, 1, 0),
//        intArrayOf(0, 0, 0, 1)
//    )

//    val isConnected = arrayOf(
//        intArrayOf(1, 1, 1, 0),
//        intArrayOf(1, 1, 0, 0),
//        intArrayOf(1, 0, 1, 1),
//        intArrayOf(0, 0, 1, 1)
//    )

//    val isConnected = arrayOf(
//        intArrayOf(1, 0, 0, 0, 0),
//        intArrayOf(0, 1, 1, 0, 0),
//        intArrayOf(0, 1, 1, 1, 0),
//        intArrayOf(0, 0, 1, 1, 0),
//        intArrayOf(0, 0, 0, 0, 1)
//    )

    val result = findCircleNum(isConnected)
    println(result)
}

fun findCircleNum(isConnected: Array<IntArray>): Int {
    var result = 0
    val size = isConnected.size
    val visitLog = BooleanArray(size)

    for(i in 0 until size) {
        if(!visitLog[i]) {  // 현재 도시를 방문하지 않은 경우
            search(i, isConnected, visitLog)    // 도시 탐색 실행
            result++    // result 1 증가
        }
    }

    return result
}

fun search(num: Int, isConnected: Array<IntArray>, visitLog: BooleanArray) {
    val size = isConnected.size
    val stack = ArrayDeque<Int>()
    stack.addLast(num)      // 시작 도시 stack에 추가
    visitLog[num] = true;   // 시작 도시 방문 여부 갱신

    while(!stack.isEmpty()) {   // stack이 비어있지 않은 경우 루프 실행
        val i = stack.removeLast()  // 현재 도시

        for(j in 0 until size){     // 도시 탐색
            if(isConnected[i][j] == 1 && !visitLog[j]){ // 탐색한 지역이 도시이고 방문하지 않은 경우
                stack.addLast(j)    // 탐색한 도시 stack에 추가
                visitLog[j] = true  // 탐색한 도시 도시 방문 여부 갱신
            }
        }
    }
}