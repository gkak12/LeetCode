package code.java;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
//        int[] asteroids = {8, -8};
//        int[] asteroids = {10, 2, -5};
//        int[] asteroids = {-1, -1, -1};
//        int[] asteroids = {1, 1, 1};
//        int[] asteroids = {1, 2, 3, -4, -1, 5};
//        int[] asteroids = {2, 3, -5, 6, -1, 4, -1};

        int[] result = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(result));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Stack<Integer> leftStack = new Stack<>();   // 왼쪽 방향 소행성 스택
        Stack<Integer> rightStack = new Stack<>();  // 오른족 소행성 방향 스택

        for(int i = len-1 ; i > -1 ; i--) {
            if(asteroids[i] < 0) {  // 현재 소행성 방향이 왼쪽인 경우
                leftStack.push(asteroids[i]);   // 왼쪽 방향 소행성 스택에 저장
            } else if(asteroids[i] > 0){    // 현재 소행성 방향이 오른쪽인 경우
                int flag = 1;   // 소행성 충돌 결과

                while(!leftStack.isEmpty()){    // 왼쪽 방향 스택이 비어있지 않을 때까지 루프 실행
                    int leftCurr = leftStack.pop();         // 왼쪽 방향 소행성 스택에서 소행성 추출
                    int absLeftCurr = Math.abs(leftCurr);   // 왼쪽 소행성 절대값

                    if(asteroids[i] == absLeftCurr){    // 현재 소행성과 왼쪽 소행성 크기가 같은 경우
                        flag = 0;   // 소행성 충돌 결과 0 설정
                        break;      // 루프 종료
                    } else if(asteroids[i] < absLeftCurr){
                        leftStack.push(leftCurr);   // 왼쪽 방향 스택에 왼쪽 소행성 다시 저장
                        flag = -1;  // 소행성 충돌 결과 -1 설정
                        break;      // 루프 종료
                    }
                }

                if(flag == 1){  // 충돌 결과 현재 소행성이 왼쪽 방향 소행성 보다 큰 경우
                    rightStack.push(asteroids[i]);  // 오른족 소행성 방향 스택에 저장
                }
            }
        }

        int[] arr = new int[leftStack.size()+rightStack.size()];    // 소행성 출돌 후 배열
        int idx = 0;

        while(!leftStack.isEmpty()){    // 왼쪽 소행성 방향 배열에 저장
            arr[idx] = leftStack.pop();
            idx++;
        }

        while(!rightStack.isEmpty()){   // 오른쪽 소행성 방향 배열에 저장
            arr[idx] = rightStack.pop();
            idx++;
        }

        return arr;
    }
}
