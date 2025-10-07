package code.kotlin

fun main(){
    val word1 = "abc"
    val word2 = "pqr"

    val result = mergeAlternately(word1, word2)
    println(result)
}

fun mergeAlternately(word1: String, word2: String): String {
    val sb = StringBuilder()
    val len = word1.length + word2.length
    var cnt = 0
    var idx1 = 0
    var idx2 = 0

    while(cnt < len){
        if(idx1 < word1.length && idx2 < word2.length){
            sb.append(word1[idx1]).append(word2[idx2])

            idx1++
            idx2++
            cnt+=2
        } else if(idx1 < word1.length){
            sb.append(word1.substring(idx1))
            break
        } else if(idx2 < word2.length){
            sb.append(word2.substring(idx2))
            break
        }
    }

    return sb.toString()
}