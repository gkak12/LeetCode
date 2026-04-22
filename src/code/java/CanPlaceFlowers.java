package code.java;

/**
 * https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
 */

public class CanPlaceFlowers {

    public static void main(String[] args) {
//        int[] flowerbed = {1,0,0,0,1};
//        int n = 1;
//        int[] flowerbed = {1,0,0,0,1};
//        int n = 2;
//        int[] flowerbed = {0,0,0,0,1};
//        int n = 2;
//        int[] flowerbed = {1,0,0,0,0};
//        int n = 2;
//        int[] flowerbed = {1,0,1,0,0};
//        int n = 2;
        int[] flowerbed = {0};
        int n = 1;

        boolean result = canPlaceFlowers(flowerbed, n);
        System.out.println(result);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int len = flowerbed.length;

        while(i < len){
            if(flowerbed[i] == 1){
                i += 2;
            } else {
                int left = i-1;
                int right = i+1;

                if(left < 0 && right >= len){
                    flowerbed[i] = 1;
                    n--;

                    continue;
                }

                if(left < 0 && flowerbed[right] == 0){
                    flowerbed[i] = 1;
                    n--;

                    continue;
                }

                if(right >= len && flowerbed[left] == 0){
                    flowerbed[i] = 1;
                    n--;

                    continue;
                }

                if(left >= 0 && right < len && flowerbed[left] == 0 && flowerbed[right] == 0){
                    flowerbed[i] = 1;
                    n--;
                }

                i++;
            }
        }

        return n < 1;
    }
}
