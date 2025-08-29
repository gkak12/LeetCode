package code.kotlin

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
//    val str1 = "ABCABC"
//    val str2 = "ABC"
//    val str1 = "ABABAB"
//    val str2 = "ABAB"
//    val str1 = "LEET"
//    val str2 = "CODE"
    val str1 = "ABC"
    val str2 = "ABCABE"

    val res = gcdOfStrings(str1, str2)
    println("res: $res")
}

fun gcdOfStrings(str1: String, str2: String): String {
    if (str1 == str2) {     // 두 문자열이 같은 경우
        return str1
    }

    if (str1 + str2 != str2 + str1) {   // 두 문자열을 서로 더해서 같지 않으면 빈 문자열 리턴
        return ""
    }

    val num1 = maxOf(str1.length, str2.length)
    val num2 = minOf(str1.length, str2.length)
    val gcd = getGcd(num1, num2)    // 최대 공약수 조회

    return str1.substring(0, gcd)   // 공통 문자열 리턴
}

fun getGcd(num1: Int, num2: Int): Int {   // 유클리드 알고리즘 사용해서 최대공약수 조회
    var x = num1
    var y = num2

    while (y != 0) {
        val temp = y
        y = x % y
        x = temp
    }

    return x
}
