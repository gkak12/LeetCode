package code.java;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=leetcode-75
 */

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
//        String digits = "23";
//        String digits = "2";
        String digits = "258";

        List<String> result = letterCombinations(digits);
        System.out.println(result);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        Map<String, String[]> map = new HashMap<>();    // 각 숫자별 문자열 저장
        map.put("2", "abc".split(""));map.put("3", "def".split(""));
        map.put("4", "ghi".split(""));map.put("5", "jkl".split(""));
        map.put("6", "mno".split(""));map.put("7", "pqrs".split(""));
        map.put("8", "tuv".split(""));map.put("9", "wxyz".split(""));

        if(digits.length() == 0){           // digits 길이가 0인 경우
            return result;
        } else if(digits.length() == 1){    // digits 길이가 1인 경우
            return Arrays.stream(map.get(digits)).toList();
        }

        String[] sArr = digits.split("");   // 입력받은 숫자를 문자열 배열로 전환
        result = searchStack(sArr, map);        // 입력받은 숫자 순서대로 조합 추출(스택)
        Collections.sort(result);               // 조합 오름차순 정렬

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        searchRecursive(sArr, map, list, sb, 0);        // 입력받은 숫자 순서대로 조합 추출(재귀)
        Collections.sort(list);                             // 조합 오름차순 정렬
        result = list;

        return result;
    }

    public static void searchRecursive(String[] sArr, Map<String, String[]> map, List<String> list, StringBuilder sb, int idx) {
        if(sb.length() == sArr.length){     // sb 길이가 입력받은 숫자 길이와 같은 경우 재귀 종료
            list.add(sb.toString());        // 현재 sb 리스트에 추가
            return;
        }

        String s_key = sArr[idx];           // 현재 인덱스에 위치한 숫자
        String[] s_arr = map.get(s_key);    // 현재 숫자의 문자열 배열

        for(String s : s_arr){  // 문자열 배열 조합 실행
            sb.append(s);       // 문자열 배열을 sb에 추가
            searchRecursive(sArr, map, list, sb, idx+1);    // 입력받은 다음 숫자 탐색
            sb.deleteCharAt(sb.length()-1);     // 기존에 추가한 문자를 sb에서 제거, 백트래킹 실행
        }
    }

    public static List<String> searchStack(String[] sArr, Map<String, String[]> map) {
        List<String> list = new ArrayList<>();
        String sKey = sArr[0];              // 첫번째 숫자
        String[] numArr = map.get(sKey);    // 첫번째 숫자에 해당하는 문자열 배열

        Stack<String[]> stack = new Stack<>();

        for(String num : numArr){   // 첫번째 숫자에 해당하는 문자열의 문자와 현재 인덱스를 스택에 저장
            stack.push(new String[]{num, "0"});
        }

        while(!stack.isEmpty()){    // 조합 탐색
            String[] curr = stack.pop();
            String currStr = curr[0];                       // 현재 문자열
            Integer currIdx = Integer.parseInt(curr[1]);    // 현재 문자열의 마지막 인덱스

            if(currIdx == sArr.length-1){   // 마지막 인덱스인 경우(탐색 종료)
                list.add(currStr);          // 현재 문자열을 리스트에 저장
                continue;
            }

            if(currIdx < sArr.length-1){    // 현재 문자열의 마지막 인덱스가 입력받은 문자열의 마지막 인덱스보다 작은 경우(탐색 진행)
                Integer nextIdx = currIdx+1;            // 다음 문자 인덱스
                String nextKey = sArr[nextIdx];         // 다음 문자
                String[] nextArr = map.get(nextKey);    // 다음 문자의 문자열 배열

                for(String next : nextArr){     // 다음 문자열 배열 정보 스택에 저장
                    stack.push(new String[]{currStr.concat(next), nextIdx.toString()});
                }
            }
        }

        return list;
    }
}
