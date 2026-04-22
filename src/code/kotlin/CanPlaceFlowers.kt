package code.kotlin

fun main() {
//    val flowerbed = intArrayOf(1, 0, 0, 0, 1)
//    val n = 1
//    val flowerbed = intArrayOf(1, 0, 0, 0, 1)
//    val n = 2
//    val flowerbed = intArrayOf(0, 0, 0, 0, 1)
//    val n = 2
//    val flowerbed = intArrayOf(1, 0, 0, 0, 0)
//    val n = 2
//    val flowerbed = intArrayOf(1, 0, 1, 0, 0)
//    val n = 2
//    val flowerbed = intArrayOf(0)
//    val n = 1
    val flowerbed = intArrayOf(1, 0, 0, 0, 0, 1)
    val n = 2

    val result = canPlaceFlowers(flowerbed, n)
    println(result)
}

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean{
    val len = flowerbed.size
    var num = n
    var i = 0

    while(i < len){
        if(flowerbed[i] == 0){  // 비어있는 경우
            val leftFlag = if(i-1 >= 0) flowerbed[i-1] == 0 else true   // 왼쪽이 비어있는지 확인
            val rightFlag = if(i+1 < len) flowerbed[i+1] == 0 else true // 오른쪽아 비어있는지 확인

            if(leftFlag && rightFlag){  // 왼쪽, 오른족 둘다 비어있는 경우, 꽃 심기
                flowerbed[i] = 1
                num--
                i++ // 현재 기준 오른쪽은 인접해서 더이상 꽃을 심을 수 없기에 패스
            }
        }

        i++
    }

    return num < 1
}