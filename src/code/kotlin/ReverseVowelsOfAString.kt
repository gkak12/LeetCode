package code.kotlin

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.*

fun main(args: Array<String>) {
    val s = "IceCreAm"
//    val s = "leetcode"

    val result = reverseVowels(s)
    println(result)
}

fun reverseVowels(s: String): String {
    val asterisk = '*'

    val set = setOf(    // 모음 Set
        'a', 'e', 'i', 'o', 'u'
        , 'A', 'E', 'I', 'O', 'U'
    )

    val stack = ArrayDeque<Char>()  // 뒤집는 연산 대신 스택 사용
    val sb = StringBuilder()

    for(i in 0 until s.length) {
        val c = s[i]

        if(set.contains(c)) {   // 모음인 경우
            sb.append(asterisk)     // sb에 모음 대신 * 추가
            stack.addLast(c)        // 스택에 모음 추가
        } else {    // 자음인 경우
            sb.append(c)    // sb에 자음 추가
        }
    }

    for(i in 0 until sb.length) {
        val c = sb[i]

        if(c == asterisk) {     // *인 경우
            val vowel = stack.removeLast()  // 스택에서 모음 추출
            sb.setCharAt(i, vowel)          // * 대신에 모음 추가
        }
    }

    val answer = sb.toString()
    return answer
}