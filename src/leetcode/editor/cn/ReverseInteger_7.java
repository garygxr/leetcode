//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
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
// Related Topics 数学 👍 3836 👎 0


package leetcode.editor.cn;

/**
 * 整数反转
 *
 * @author DY
 * @date 2023-06-02 11:43:56
 */
public class ReverseInteger_7 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ReverseInteger_7().new Solution();
        int reverse = solution.reverse(1534236469);
        System.out.println(reverse);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int sum = 0;
            while (x != 0) {
                int a = x % 10;
                x = x / 10;
                if (sum == 214748364 || sum == -214748364) {
                    if (a > 8 || a < -7) {
                        return 0;
                    }
                } else if (sum > 214748364 || sum < -214748364) {
                    return 0;
                }
                sum = sum * 10 + a;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}