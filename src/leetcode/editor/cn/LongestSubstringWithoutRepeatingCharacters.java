//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4817 👎 0


package leetcode.editor.cn;

import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.regex.Matcher;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        int abcbabcde = solution.lengthOfLongestSubstring("abcbabcde");
        System.out.println(abcbabcde);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();

            int start=0;
            int end =0;

            int maxLength=0;
            HashMap<Character, Integer> charHashMap = new HashMap();

            while (end<chars.length){
                if (charHashMap.containsKey(chars[end])){
                    Integer integer = charHashMap.get(chars[end]);
                    if (start<=integer){
                        int currentLength = end-start;
                        maxLength = Math.max(currentLength,maxLength);
                        start=integer+1;
                    }
                }
                charHashMap.put(chars[end],end);
                end++;
            }
            maxLength= Math.max(end - start, maxLength);

            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}