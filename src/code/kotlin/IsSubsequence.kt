package code.kotlin

/**
 * https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    // val s = "abc"
    // val t = "ahbgdc"
    // val s = "axc"
    // val t = "ahbgdc"
    val s = "a"
    val t = "abc"

    println(isSubsequence(s, t))
}

fun isSubsequence(s: String, t: String): Boolean {
    var sIdx = 0  // 부분 문자열 인덱스
    var tIdx = 0  // 전체 문자열 인덱스

    while (tIdx < t.length) {
        // 부분 문자열 인덱스가 부분 문자열 보다 작고, 부분 문자열 인덱스 원소와 전체 문자열 인덱스 원소가 같은 경우
        if (sIdx < s.length && s[sIdx] == t[tIdx]) {
            sIdx++
        }
        tIdx++
    }

    return sIdx == s.length  // 부분 문자열 다 탐색한 경우
}