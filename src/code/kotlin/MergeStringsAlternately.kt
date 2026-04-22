package code.kotlin

fun main(){
    val word1 = "abc"
    val word2 = "pqr"
//    val word1 = "ab"
//    val word2 = "pqrs"
//    val word1 = "abcd"
//    val word2 = "pq"

    val result = mergeAlternately(word1, word2)
    println(result)
}

fun mergeAlternately(word1: String, word2: String): String {
    val sb = StringBuilder()
    val len = word1.length + word2.length   // word1, word2 문자열 합친 길이
    var cnt = 0
    var idx1 = 0
    var idx2 = 0

    while(cnt < len){
        if(idx1 < word1.length && idx2 < word2.length){     // word1 인덱스와 word2 인덱스 둘다 문자열보다 작으면 동시에 추가
            sb.append(word1[idx1]).append(word2[idx2])      // word1, word2 문자 추가

            idx1++  // word1 인덱스 증가
            idx2++  // word2 인덱스 증가
            cnt+=2  // 추가한 문자 2개 증가
        } else if(idx1 < word1.length){     // word1 인덱스만 문자열보다 작으면 word1만 추가
            sb.append(word1.substring(idx1))    // word1 나머지 문자 추가
            break
        } else if(idx2 < word2.length){     // word2 인덱스만 문자열보다 작으면 word2만 추가
            sb.append(word2.substring(idx2))    // word2 나머지 문자 추가
            break
        }
    }

    return sb.toString()
}