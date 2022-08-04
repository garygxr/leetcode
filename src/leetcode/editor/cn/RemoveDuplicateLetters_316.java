////给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：s = "bcabc"
////输出："abc"
//// 
////
//// 示例 2： 
////
//// 
////输入：s = "cbacdcbc"
////输出："acdb" 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= s.length <= 10⁴ 
//// s 由小写英文字母组成 
//// 
////
//// 
////
//// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
////distinct-characters 相同 
//// Related Topics 栈 贪心 字符串 单调栈 👍 779 👎 0
//

package leetcode.editor.cn;

import java.util.ArrayDeque;

/**
 * @author gary gan
 * @date 2022-07-29 10:40:21
 */
public class RemoveDuplicateLetters_316 {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateLetters_316().new Solution();
        String aabac = solution.removeDuplicateLetters("cbacdcbc");
        System.out.println(aabac);
    }

    /**
     * 去除重复字母
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            char[] chars = s.toCharArray();
            int[] lastChars = new int[26];
            for (int i = 0; i < chars.length; i++) {
                lastChars[chars[i] - 'a'] = i;
            }
            ArrayDeque<Character> deque = new ArrayDeque<>();
            boolean[] containsArray = new boolean[26];

            for (int i = 0; i < chars.length; i++) {
                char currentChar = chars[i];
                if (containsArray[currentChar - 'a']) {
                    continue;
                }
                while (!deque.isEmpty() && deque.peekLast() > currentChar && lastChars[deque.peekLast() - 'a'] > i) {
                    Character preChar = deque.removeLast();
                    containsArray[preChar - 'a'] = false;
                }
                deque.add(currentChar);
                containsArray[currentChar - 'a'] = true;

            }

            StringBuilder sb = new StringBuilder(deque.size());
            for (Character character : deque) {
                sb.append(character);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}