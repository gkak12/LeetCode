package com.leetcode;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        String s = "the sky is blue";
//        String s = "  hello world  ";
//        String s = "a good   example";

        String result = reverseWords(s);
        System.out.println(result);
    }

    public static String reverseWords(String s) {
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = sArr.length-1; i >= 0; i--){
            if(sArr[i].equals("")){
                continue;
            }

            sb.append(sArr[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
