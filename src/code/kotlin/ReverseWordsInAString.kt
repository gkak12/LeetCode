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
    val sArr = s.split(" ")
    val sb: StringBuilder = StringBuilder()

    for(i in sArr.size-1 downTo 0){
        if(sArr[i].isEmpty()){
            continue
        }

        sb.append(sArr[i])
        sb.append(" ")
    }

    return sb.toString().trim()
}