package com.leetcode;

/**
 * https://leetcode.com/problems/smallest-number-in-infinite-set/submissions/1650235487/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SmallestInfiniteSet {

    private Queue<Integer> queue;   // 우선순위 큐(가장 작은 수 조회 목적)
    private Set<Integer> set;   // Set(숫자 중복 여부 확인 목적)

    public SmallestInfiniteSet() {
        queue = new PriorityQueue<>();  // 우선순위 큐 초기화
        set = new HashSet<>();          // Set 초기화

        for(int i = 1 ; i <= 1000 ; i++){
            queue.add(i);
            set.add(i);
        }
    }

    public int popSmallest() {
        int val = queue.poll(); // 우선순위 큐에서 가장 작은 수 반환
        set.remove(val);        // Set에서 가장 작은 수 제거
        return val;
    }

    public void addBack(int num) {
        if(!set.contains(num)){ // Set에 숫자 없으면
            queue.add(num);     // 우선순위 큐에 숫자 저장
            set.add(num);       // Set에 숫자 저장
        }
    }
}
