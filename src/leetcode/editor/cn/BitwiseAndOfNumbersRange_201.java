//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 5, right = 7
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：left = 0, right = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：left = 1, right = 2147483647
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= left <= right <= 2³¹ - 1 
// 
//
// Related Topics 位运算 👍 517 👎 0


package leetcode.editor.cn;

/**
 * 数字范围按位与
 *
 * @author DY
 * @date 2024-07-01 15:48:04
 */
public class BitwiseAndOfNumbersRange_201 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new BitwiseAndOfNumbersRange_201().new Solution();
        int i = solution.rangeBitwiseAnd(2, 4);
        System.out.println(i);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int shift = 0;
            while (m < n) {
                m >>= 1;
                n >>= 1;
                ++shift;
            }
            return m << shift;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}