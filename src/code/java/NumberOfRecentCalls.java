package code.java;

/**
 * https://leetcode.com/problems/number-of-recent-calls/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.ArrayList;
import java.util.List;

public class NumberOfRecentCalls {

    static class RecentCounter {

        private List<Integer> list; // 요청 저장하는 리스트

        public RecentCounter() {
            list = new ArrayList<>();
        }

        public int ping(int t) {
            list.add(t);    // 현재 요청 시각 리스트에 저장
            int stdTime = t-3000;   // 현재 요청 시각에서 3000 밀리세컨드 뺀 기준 시각
            int cnt = 0;    // 기준 시각 보다 오래된 요청 개수

            for(int time : list){   // 리스트 조회하면서 기준 시각 보다 오래된 요청 개수 count
                if(time < stdTime){
                    cnt++;
                } else {
                    break;
                }
            }

            return list.size()-cnt;     // 전체 요청에서 오래된 요청 제외한 개수 리턴
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
