package code.kotlin

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
    val s = "the sky is blue"
//    val s = "  hello world  "
//    val s = "a good   example"

    val result = reverseWords(s)
    println(result)
}

fun reverseWords(s: String): String {
    return s.trim()
        .split(Regex("\\s+"))   // 공백 기준으로 문자열 리스트 생성
        .reversed() // 리스트 현재 순서 반대로 뒤집기
        .joinToString(" ")  // 리스트 요소 사이에 공백 추가한 뒤 리턴
}