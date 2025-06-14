package code.kotlin

/**
 * https://leetcode.com/problems/keys-and-rooms?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.*

fun main(){
//    val rooms = listOf(
//        listOf(1),
//        listOf(2),
//        listOf(3),
//        listOf()
//    )

    val rooms = listOf(
        listOf(1, 3),
        listOf(3, 0, 1),
        listOf(2),
        listOf(0)
    )

    val result = canVisitAllRooms(rooms)
    println(result)
}

fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    val set = mutableSetOf<Int>()

    for(i in rooms.indices){    // 방문 해야 할 전체 방 번호 Set
        set.add(i)
    }

    val stack = Stack<Int>()
    stack.push(0)   // start room(0번 방)
    val visitLog = BooleanArray(set.size+1)     // 0번 방 포함

    while(stack.isNotEmpty()){
        val currRoom = stack.pop()
        visitLog[currRoom] = true   // 현재 방 방문여부 수정

        if(set.contains(currRoom)){     // 현재 방이 방문해야 할 방인 경우
            set.remove(currRoom)        // set에서 제거
        }

        val currKeys = rooms[currRoom]  // 현재 방에 있는 키 목록

        for(key in currKeys){
            if(!visitLog[key]){     // 아직 방문하지 않은 방인 경우 방 키 추가
                stack.push(key)
            }
        }
    }

    val result = set.isEmpty()  // 모든 방 방문여부 확인
    return result;
}