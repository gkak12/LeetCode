package code.kotlin

fun main(){
//    val nums = intArrayOf(0, 1, 0, 3, 12)
//    val nums = intArrayOf(0)
//    val nums = intArrayOf(1, 0, 1)
    val nums = intArrayOf(1, 2, 3, 0, 5 ,0, 0)

    moveZeros(nums)
}

fun moveZeros(nums: IntArray) {
    var zeroIdx = 0     // 0 인덱스
    var idx = 0         // 정수 인덱스

    while(idx < nums.size){
        // 회전 돌 때마다 가장 앞에 있는 0 인덱스 조회
        if(nums[zeroIdx] != 0){
            zeroIdx++
        }

        // 0 인덱스가 정수 인덱스보다 작고, 0 인덱스 원소가 0이고, 정수 인덱스 원소가 정수인 경우 교환 실행
        if(zeroIdx < idx && nums[zeroIdx] == 0 && nums[idx] != 0){
            val tmp = nums[idx]
            nums[idx] = nums[zeroIdx]
            nums[zeroIdx] = tmp
        }

        idx++
    }

    print(nums.joinToString())
}