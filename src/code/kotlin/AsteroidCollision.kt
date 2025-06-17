package code.kotlin

/**
 * https://leetcode.com/problems/asteroid-collision/submissions/1666998376/?envType=study-plan-v2&envId=leetcode-75
 */

import kotlin.math.absoluteValue

fun main(){
    val asteroids = intArrayOf(5, 10, -5)
//    val asteroids = intArrayOf(8, -8)
//    val asteroids = intArrayOf(10, 2, -5)
//    val asteroids = intArrayOf(-1, -1, -1)
//    val asteroids = intArrayOf(1, 1, 1)
//    val asteroids = intArrayOf(1, 2, 3, -4, -1, 5)
//    val asteroids = intArrayOf(2, 3, -5, 6, -1, 4, -1)

    val result = asteroidCollision(asteroids)
    println(result.joinToString(" "))
}

fun asteroidCollision(asteroids: IntArray): IntArray {
    val size = asteroids.size
    val leftStack = ArrayDeque<Int>()   // 왼쪽 방향 소행성 스택
    val rightStack = ArrayDeque<Int>()  // 오른족 소행성 방향 스택

    for(i in size-1 downTo 0){
        if(asteroids[i] < 0){   // 현재 소행성 방향이 왼쪽인 경우
            leftStack.addLast(asteroids[i])    // 왼쪽 방향 소행성 스택에 저장
        } else if(asteroids[i] > 0){    // 현재 소행성 방향이 오른쪽인 경우
            var flag = 1    // 소행성 충돌 결과

            while(leftStack.isNotEmpty()){  // 왼쪽 방향 스택이 비어있지 않을 때까지 루프 실행
                val leftCurr = leftStack.removeLast()  // 왼쪽 방향 소행성 스택에서 소행성 추출

                if(asteroids[i] == leftCurr.absoluteValue){    // 현재 소행성과 왼쪽 소행성 크기가 같은 경우
                    flag = 0    // 소행성 충돌 결과 0 설정
                    break       // 루프 종료
                } else if(asteroids[i] < leftCurr.absoluteValue){   // 현재 소행성이 왼쪽 소행성 보다 작은 경우
                    leftStack.addLast(leftCurr)     // 왼쪽 방향 스택에 왼쪽 소행성 다시 저장
                    flag = -1   // 소행성 충돌 결과 -1 설정
                    break       // 루프 종료
                }
            }

            if(flag == 1){  // 충돌 결과 현재 소행성이 왼쪽 방향 소행성 보다 큰 경우
                rightStack.addLast(asteroids[i])    // 오른족 소행성 방향 스택에 저장
            }
        }
    }

    val arr = IntArray(leftStack.size+rightStack.size)   // 소행성 출돌 후 배열
    var idx = 0

    while(leftStack.isNotEmpty()){  // 왼쪽 소행성 방향 배열에 저장
        arr[idx] = leftStack.removeLast()
        idx++
    }

    while(rightStack.isNotEmpty()){ // 오른쪽 소행성 방향 배열에 저장
        arr[idx] = rightStack.removeLast()
        idx++
    }

    return arr
}