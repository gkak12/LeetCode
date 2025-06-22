package code.kotlin

/**
 * https://leetcode.com/problems/zigzag-conversion/submissions/1353234404/
 */

fun main(){
    val s = "PAYPALISHIRING"
    val numRows = 3

    val result = convert(s, numRows)
    println(result)
}

fun convert(s: String, numRows: Int): String {
    if(numRows == 1){
        return s
    }

    val len = s.length
    val arr = Array(numRows){CharArray(len)}
    var flag = true // true: 아래 방향, false: 대각선 방향
    var row = 0
    var col = 0

    for(idx in 0 until len) {
        val c = s[idx]
        arr[row][col] = c

        if(row == 0){   // 아래 방향으로 전환
            flag = true
        } else if(row == numRows-1){    // 대각선 방향으로 전환
            flag = false
        }

        if(flag){   // 아래 방향
            row++
        } else {    // 대각선 방향
            row--
            col++
        }
    }

    val sb = StringBuilder()

    for(tmp in arr){
        sb.append(tmp)
    }

    val result = sb.toString().replace("\u0000", "")
    return result
}