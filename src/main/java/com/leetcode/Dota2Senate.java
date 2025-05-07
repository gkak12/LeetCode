package com.leetcode;

/**
 * https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {

    public static void main(String[] args) {
        String senate = "RD";
//        String senate = "RDD";
//        String senate = "RRRD";
//        String senate = "DDRRR";

        String result = predictPartyVictory(senate);
        System.out.println(result);
    }

    public static String predictPartyVictory(String senate) {
        int len = senate.length();
        String party = null;

        Queue<Integer> rqueue = new LinkedList<>(); // Radiant 인덱스 저장 큐
        Queue<Integer> dqueue = new LinkedList<>(); // Dire 인덱스 저장 큐

        for(int i = 0; i < len; i++){   // Radiant Dire 큐 초기화
            if(senate.charAt(i) == 'R'){
                rqueue.offer(i);
            } else{
                dqueue.offer(i);
            }
        }

        int idx = len;

        while(!rqueue.isEmpty() && !dqueue.isEmpty()){  // 탐색 시작
            int rIdx = rqueue.poll();
            int dIdx = dqueue.poll();

            if(rIdx < dIdx){    // Radiant 인덱스가 Dire 인덱스 보다 작은 경우 승리
                rqueue.offer(idx++);    // Radiant 큐 추가
            } else{     // Dire 인덱스가 Radiant 인덱스 보다 작은 경우 승리
                dqueue.offer(idx++);    // Dire 큐 추가
            }
        }

        party = rqueue.isEmpty() ? "Dire" : "Radiant";  // 비어있지 않은 큐(승리한 정당) 리턴
        return party;
    }
}
