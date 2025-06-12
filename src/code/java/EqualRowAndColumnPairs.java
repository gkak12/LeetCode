package code.java;

/**
 * https://leetcode.com/problems/equal-row-and-column-pairs/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {

    public static void main(String[] args) {
        int[][] grid = {{3,2,1},{1,7,6}, {2,7,7}};
//        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};

        int result = equalPairs(grid);
        System.out.println(result);
    }

    public static int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();

        for (int[] g : grid) {    // row map에 저장
            map.put(Arrays.toString(g), map.getOrDefault(Arrays.toString(g), 0) + 1);
        }

        int cnt = 0;

        for(int j = 0 ; j < grid[0].length ; j++) { // col 조회하면서 map에 있는 row 카운트
            int[] tmp = new int[grid.length];

            for(int i = 0 ; i < grid.length ; i++) {
                tmp[i] = grid[i][j];
            }

            cnt += map.getOrDefault(Arrays.toString(tmp), 0);
        }

        return cnt;
    }
}
