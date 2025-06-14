package code.kotlin

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/1617254917/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
    val s = "abciiidef"
    val k = 3

    val result = maxVowels(s, k)
    println(result)
}

fun maxVowels(s: String, k: Int): Int {
    var cnt = 0

    for(i in 0 until k){    // 초기 모음 갯수
        val c = s.get(i)
        if(checkVowel(c)) cnt++
    }

    var max = cnt   // 초기 모음 갯수를 max로 설정

    for(i in k until s.length){     // 배열 확장하면서 모음 갯수 갱신
        // 이전 글자가 모음인 경우 cnt 1 감소
        val beforeC = s.get(i-k)
        if(checkVowel(beforeC)) cnt--

        // 현재 글자가 모음인 경우 cnt 1 증가
        var currC = s.get(i)
        if(checkVowel(currC)) cnt++

        max = maxOf(max, cnt)   // max와 cnt 비교하면서 갱신
    }

    return max
}

fun checkVowel(c: Char): Boolean {  // 모음 판단하는 메서드
    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
        return true
    } else {
        return false
    }
}