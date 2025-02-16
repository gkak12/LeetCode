package com.leetcode;

/**
 * https://leetcode.com/problems/zigzag-conversion/submissions/1353234404/
 */

public class ZigzagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        convert(s, numRows);
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        char[][] arr = new char[numRows][s.length()];
        boolean flag = true; // true: 아래방향, false: 사선방향
        int row = 0;
        int col = 0;

        for (int idx = 0; idx < s.length(); idx++) {
            char c = s.charAt(idx);
            arr[row][col] = c;

            if (row == 0) { // 수직방향으로 전환
                flag = true;
            } else if (row == numRows - 1) { // 사선방향으로 전환
                flag = false;
            }

            if (flag) { // 수직방향
                row++;
            } else { // 사선방향
                row--;
                col++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char[] tmp : arr) {
            sb.append(tmp);
        }

        String res = sb.toString().replaceAll("\0", "");
        return res;
    }
}
