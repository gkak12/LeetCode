package code.java;

/**
 * https://leetcode.com/problems/find-the-highest-altitude/?envType=study-plan-v2&envId=leetcode-75
 */

public class FindTheHighestAltitude {

    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
//        int[] gain = {-4,-3,-2,-1,4,3,2};

        int result = largestAltitude(gain);
        System.out.println(result);
    }

    public static int largestAltitude(int[] gain) {
        int max = 0;
        int[] alt = new int[gain.length+1];

        System.arraycopy(gain, 0, alt, 1, gain.length);

        for(int i = 1 ; i < alt.length; i++){
            alt[i] += alt[i-1];
            max = Math.max(max, alt[i]);
        }

        return max;
    }
}
