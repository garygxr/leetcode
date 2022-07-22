//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 👍 2106 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

/**
 * @author gary gan
 * @date 2022-07-21 10:49:20
 */
public class PalindromeNumber_9 {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber_9().new Solution();
        System.out.println(solution.isPalindrome(11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x == 0) {
                return true;
            }
            if (x < 0 || x % 10 == 0) {
                return false;
            }
            char[] chars = String.valueOf(x).toCharArray();
            for (int r = 0, l = chars.length - 1; r < l; r++, l--) {
                if (chars[r]!=chars[l]){
                    return false;
                }
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}