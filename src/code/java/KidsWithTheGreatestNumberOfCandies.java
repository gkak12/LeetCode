package code.java;

/**
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;

//        int[] candies = {4,2,1,1,2};
//        int extraCandies = 1;

//        int[] candies = {12,1,12};
//        int extraCandies = 10;

        List<Boolean> result = kidsWithCandies(candies, extraCandies);
        System.out.println(result.toString());
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int maxCandy = Arrays.stream(candies).max().getAsInt();

        for(int candy : candies) {
            int val = candy+extraCandies;
            boolean isCandy = val >= maxCandy ? true : false;

            list.add(isCandy);
        }

        return list;
    }
}
