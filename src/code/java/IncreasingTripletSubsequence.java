package code.java;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
 */

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5};
//        int[] nums = {5,4,3,2,1};
//        int[] nums = {2,1,5,0,4,6};
        int[] nums = {1,5,0,4,1,3};

        boolean result = increasingTriplet(nums);
        System.out.println(result);
    }

    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= first) {   // 현재 숫자가 가장 작으면 first 업데이트
                first = n;
            } else if (n <= second) {   // 현재 숫자가 first보다는 크고 second보다 작거나 같으면 second 업데이트
                second = n;
            } else {    // 현재 숫자가 first와 second보다 크면 리턴(3개 찾았기 때문에)
                return true;
            }
        }

        return false;
    }
}
