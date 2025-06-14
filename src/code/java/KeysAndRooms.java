package code.java;

/**
 * https://leetcode.com/problems/keys-and-rooms?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.*;

public class KeysAndRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = List.of(
            List.of(1),
            List.of(2),
            List.of(3),
            List.of()
        );

//        List<List<Integer>> rooms = List.of(
//                List.of(1,3),
//                List.of(3,0,1),
//                List.of(2),
//                List.of(0)
//        );

        boolean result = canVisitAllRooms(rooms);
        System.out.println(result);
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < rooms.size(); i++){  // 방문 해야 할 전체 방 번호 Set
            set.add(i);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);  // start room(0번 방)
        boolean[] visitLog = new boolean[set.size()+1];     // 0번 방 포함

        while(!stack.isEmpty()){
            Integer currRoom = stack.pop();
            visitLog[currRoom] = true;      // 현재 방 방문여부 수정

            if(set.contains(currRoom)){     // 현재 방이 방문해야 할 방인 경우
                set.remove(currRoom);       // set에서 제거
            }

            List<Integer> currKeys = rooms.get(currRoom);   // 현재 방에 있는 키 목록

            for(Integer key : currKeys){
                if(!visitLog[key]){     // 아직 방문하지 않은 방인 경우 방 키 추가
                    stack.push(key);
                }
            }
        }

        boolean result = set.isEmpty();  // 모든 방 방문여부 확인
        return result;
    }
}
