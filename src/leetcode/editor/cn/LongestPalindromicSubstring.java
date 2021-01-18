//给你一个字符串 s，找到 s 中最长的回文子串。 
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
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3099 👎 0


package leetcode.editor.cn;

import java.util.Scanner;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            String aba = solution.longestPalindrome(next);
            System.out.println(aba);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String maxLengthStr  = s.substring(0,1);
            for (int i = 0; i < s.length() - 1; i++) {
                String oddString = findPalindrome(s, i, i);
                String evenString = findPalindrome(s, i, i + 1);
                String maxStr = oddString.length() > evenString.length() ? oddString : evenString;
                if (maxStr.length()>maxLengthStr.length()){
                    maxLengthStr=maxStr;
                }
            }
            return maxLengthStr;
        }

        public String findPalindrome(String s, int left, int right) {
            int len = s.length();
            int i =left;
            int j = right;
            while (i>=0&&j<len){
                if (s.charAt(i)==s.charAt(j)){
                    i--;
                    j++;
                }else {
                    break;
                }
            }
            return s.substring(i+1,j);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}