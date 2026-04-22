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
        int len = flowerbed.length;

        for(int i = 0; i < len; i++){
            if(flowerbed[i] == 0){  // 비어있는 경우
                boolean leftFlag = i-1 >= 0 ? flowerbed[i-1] == 0 : true;   // 왼쪽이 비어있는지 확인
                boolean rightFlag = i+1 < len ? flowerbed[i+1] == 0 : true; // 오른쪽아 비어있는지 확인

                if(leftFlag && rightFlag){  // 왼쪽, 오른족 둘다 비어있는 경우, 꽃 심기
                    flowerbed[i] = 1;
                    n--;
                    i++;    // 현재 기준 오른쪽은 인접해서 더이상 꽃을 심을 수 없기에 패스
                }
            }
        }

        return n < 1;
    }
}
