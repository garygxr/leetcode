//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2152 👎 0


package leetcode.editor.cn;

/**
 * 和为 K 的子数组
 *
 * @author DY
 * @date 2023-11-16 09:26:11
 */
public class SubarraySumEqualsK_560 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SubarraySumEqualsK_560().new Solution();
        int i = solution.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(i);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int left = 0;
            while (left < nums.length) {
                int right = left;
                int temp = nums[right];
                if (temp == k) {
                    count++;
                }
                while (right + 1 < nums.length) {
                    temp += nums[++right];
                    if (temp == k) {
                        count++;
                    }
                }
                left++;
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}