package code.kotlin

fun main(){
    val k = 3
    val n = 7
//    val k = 3
//    val n = 9

    val result = combinationSum3(k, n)
    println("result is $result")
}

fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    for(i in 1 .. 9){
        val list = mutableListOf<Int>()
        list.add(i)

        search(k, n, list, result)  // 탐색 수행
    }

    return result
}

fun search(k: Int, n: Int, list: MutableList<Int>, result: MutableList<List<Int>>) {
    val sum = list.sum()

    if(sum == n && list.size == k){     // 모든 조건에 만족하는 경우
        result.add(ArrayList(list))     // 현재 리스트 result에 추가
        return
    }

    if(list.size == k){     // 모든 조건에 만족하지 않고, 이미 탐색을 마친 경우
        return
    }

    val startNum = list.last()  // 리스트의 마지막 숫자를 시작 숫자로 설정

    for(i in startNum .. 9){
        // 다음 숫자가 중복되지 않았고, 리스트 사이즈가 k 보다 작고, 다음 숫자를 더한 값이 n 보다 작은 경우
        if(!list.contains(i) && list.size < k && sum+i <= n){
            list.add(i)                     // 다음 숫자 추가
            search(k, n, list, result)      // 탐색 수행
            list.removeLast()               // 추가한 숫자 제거(백트래킹 수행)
        }
    }
}