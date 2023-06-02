//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6542 👎 0


package leetcode.editor.cn;

/**
 * 最长回文子串
 *
 * @author DY
 * @date 2023-06-02 09:51:09
 */
public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LongestPalindromicSubstring_5().new Solution();
        String s = solution.longestPalindrome("babad");
        System.out.println(s);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            String res = "";
            boolean[] P = new boolean[n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= i; j--) {
                    P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                    if (P[j] && j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}