//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 962 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author gary gan
 * @date 2022-08-05 14:52:40
 */
public class FindAllAnagramsInAString_438 {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString_438().new Solution();
        List<Integer> anagrams = solution.findAnagrams2("ababab","ab");
        anagrams.forEach(System.out::println);
    }

    /**
     * 找到字符串中所有字母异位词
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if (s.length() < p.length()) {
                return new ArrayList<>(0);
            }
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> windows = new HashMap<>();
            for (char c : p.toCharArray()) {
                need.merge(c, 1, Integer::sum);
            }

            int left = 0;
            int right = 0;
            int valid = 0;
            List<Integer> countList = new ArrayList<>();
            while (right < s.length()) {
                Character c = s.charAt(right);
                right++;
                if (need.getOrDefault(c, 0) > 0) {
                    windows.merge(c, 1, Integer::sum);
                    if (windows.get(c) == need.get(c)) {
                        valid++;
                    }
                }
                while (right - left >= p.length()) {
                    if (valid == need.size()) {
                        countList.add(left);
                    }
                    char d = s.charAt(left);
                    left++;
                    if (need.getOrDefault(d, 0) > 0) {
                        if (windows.get(d) == need.get(d)) {
                            valid--;
                        }
                        windows.merge(d, -1, Integer::sum);
                    }
                }
            }
            return countList;
        }

        public List<Integer> findAnagrams2(String s, String p) {
            int sLen = s.length(), pLen = p.length();

            if (sLen < pLen) {
                return new ArrayList<Integer>();
            }

            List<Integer> ans = new ArrayList<Integer>();
            int[] sCount = new int[26];
            int[] pCount = new int[26];
            for (int i = 0; i < pLen; ++i) {
                ++sCount[s.charAt(i) - 'a'];
                ++pCount[p.charAt(i) - 'a'];
            }

            if (Arrays.equals(sCount, pCount)) {
                ans.add(0);
            }

            for (int i = 0; i < sLen - pLen; ++i) {
                --sCount[s.charAt(i) - 'a'];
                ++sCount[s.charAt(i + pLen) - 'a'];

                if (Arrays.equals(sCount, pCount)) {
                    ans.add(i + 1);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}