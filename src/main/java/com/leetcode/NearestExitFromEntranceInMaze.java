package com.leetcode;

/**
 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/submissions/1650299240/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {

    public static void main(String[] args) {
        char[][] maze = {
                {'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}
        };
        int[] entrance = {1,2};

//        char[][] maze = {
//                {'+','+','+'},
//                {'.','.','.'},
//                {'+','+','+'}
//        };
//        int[] entrance = {1,0};
        
        int result = nearestExit(maze, entrance);
        System.out.println(result);
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        boolean[][] visitLog = new boolean[rows][cols];
        visitLog[entrance[0]][entrance[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currI = curr[0];
            int currJ = curr[1];
            int currStep = curr[2];

            // 현재 위치가 시작 위치가 아니고 출구에 도착한 경우
            if((currI != entrance[0] || currJ != entrance[1]) && (currI == 0 || currI == rows-1 || currJ == 0 || currJ == cols-1)) {
                return currStep;
            }

            for(int i = 0; i < di.length; i++) {
                int nextI = currI + di[i];
                int nextJ = currJ + dj[i];

                if(nextI >= 0 && nextI < rows && nextJ >= 0 && nextJ < cols && !visitLog[nextI][nextJ] && maze[nextI][nextJ] == '.') {
                    queue.offer(new int[]{nextI, nextJ, currStep+1});   // 다음 노드 추가
                    visitLog[nextI][nextJ] = true;  // 다음 노드 방문 처리(시간 제한 방지 목적)
                }
            }
        }

        return -1;
    }
}
