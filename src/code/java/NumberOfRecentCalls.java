package code.java;

/**
 * https://leetcode.com/problems/number-of-recent-calls/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {

    static class RecentCounter {

        private Queue<Integer> queue; // 요청 시각을 저장하는 큐

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);    // 현재 요청 시각을 큐에 저장
            int stdTime = t-3000;   // 현재 요청 시각에서 3000 밀리세컨드 뺀 기준 시각

            while(!queue.isEmpty() && queue.peek() < stdTime){  // 큐가 비어있지 않고, 기준 시각보다 작은 경우 큐에서 제거
                queue.poll();
            }

            return queue.size();     // 현재 큐 사이즈 리턴
        }
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // requests = [1], range is [-2999,1], return 1
        System.out.println(recentCounter.ping(100));   // requests = [1, 100], range is [-2900,100], return 2
        System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001], range is [1,3001], return 3
        System.out.println(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
    }
}
