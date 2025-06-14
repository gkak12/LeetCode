package code.kotlin

/**
 * https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75
 */

fun main(){
    val senate = "RD"
//    val senate = "RDD"
//    val senate = "RRRD"
//    val senate = "DDRRR"

    val result = predictPartyVictory(senate)
    println(result)
}

fun predictPartyVictory(senate: String): String {
    val len  = senate.length

    val rqueue = ArrayDeque<Int>()
    val dqueue = ArrayDeque<Int>()

    for(i in 0 until len){  // Radiant Dire 큐 초기화
        if(senate[i] == 'R'){
            rqueue.add(i)
        } else {
            dqueue.add(i)
        }
    }

    var idx = len

    while(rqueue.isNotEmpty() && dqueue.isNotEmpty()){  // 탐색 시작
        var rIdx: Int = rqueue.removeFirst()
        var dIdx: Int = dqueue.removeFirst()

        if(rIdx < dIdx){    // Radiant 인덱스가 Dire 인덱스 보다 작은 경우 승리
            rqueue.add(idx++)   // Radiant 큐 추가
        } else {    // Dire 인덱스가 Radiant 인덱스 보다 작은 경우 승리
            dqueue.add(idx++)   // Dire 큐 추가
        }
    }

    val party = if(rqueue.isEmpty()) "Dire" else "Radiant"  // 비어있지 않은 큐(승리한 정당) 리턴
    return party
}