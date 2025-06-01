package com.leetcode;

/**
 * https://leetcode.com/problems/smallest-number-in-infinite-set/submissions/1650235487/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SmallestInfiniteSet {

    private Queue<Integer> queue;
    private Set<Integer> set;

    public SmallestInfiniteSet() {
        queue = new PriorityQueue<>();
        set = new HashSet<>();

        for(int i = 1 ; i <= 1000 ; i++){
            queue.add(i);
            set.add(i);
        }
    }

    public int popSmallest() {
        int val = queue.poll();
        set.remove(val);
        return val;
    }

    public void addBack(int num) {
        if(!set.contains(num)){
            queue.add(num);
            set.add(num);
        }
    }
}
