package leetcode.editor.cn;

import java.util.HashMap;

/**
 * @Author garygan
 * @Date 2022/7/19 18:35
 * @Description
 */
public class FindMinArray {
    public static void main(String[] args) {
        String s = "DAABCD";
        String t = "ABC";
        findMinArray(s, t);
    }

    public static void findMinArray(String s, String t) {
        char[] sArray = s.toCharArray();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            Integer integer = tMap.get(c);
            if (integer == null) {
                tMap.put(c, 1);
            } else {
                tMap.put(c, integer++);
            }

        }
        HashMap<Character, Integer> tempMap = new HashMap<>(tMap);

        int r = 0;
        // 找出最右边开始第一个匹配的r
        while (r < s.length()) {
            Integer number = tempMap.get(sArray[r]);
            if (number != null) {
                if (number>1){
                    tempMap.put(sArray[r],number-1);
                }else {
                    tempMap.remove(sArray[r]);
                }
                break;
            }
            r++;
        }
        int minL = 0;
        int minR = s.length() - 1;

        for (int l = r; l < s.length(); l++) {
            Integer leftNumber = tempMap.get(sArray[l]);
            if (leftNumber != null) {
                if (leftNumber > 1) {
                    tempMap.put(sArray[l], leftNumber--);
                } else {
                    tempMap.remove(sArray[l]);
                }
            }
            if (tempMap.size() == 0) {

                // 移动右指针
                while (++r < l) {
                    if (tMap.containsKey(sArray[r])){
                        tempMap.put(sArray[r], 1);
                        break;
                    }
                }

                if (minR - minL > r - l) {
                    minR = r;
                    minL = l;
                }
            }


        }
    }
}
