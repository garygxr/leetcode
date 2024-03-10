//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你需要执行以下操作 恰好 k 次，最大化你的得分： 
//
// 
// 从 nums 中选择一个元素 m 。 
// 将选中的元素 m 从数组中删除。 
// 将新元素 m + 1 添加到数组中。 
// 你的得分增加 m 。 
// 
//
// 请你返回执行以上操作恰好 k 次后的最大得分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5], k = 3
//输出：18
//解释：我们需要从 nums 中恰好选择 3 个元素并最大化得分。
//第一次选择 5 。和为 5 ，nums = [1,2,3,4,6] 。
//第二次选择 6 。和为 6 ，nums = [1,2,3,4,7] 。
//第三次选择 7 。和为 5 + 6 + 7 = 18 ，nums = [1,2,3,4,8] 。
//所以我们返回 18 。
//18 是可以得到的最大答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,5,5], k = 2
//输出：11
//解释：我们需要从 nums 中恰好选择 2 个元素并最大化得分。
//第一次选择 5 。和为 5 ，nums = [5,5,6] 。
//第二次选择 6 。和为 6 ，nums = [5,5,7] 。
//所以我们返回 11 。
//11 是可以得到的最大答案。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 1 <= k <= 100 
// 
//
// Related Topics 贪心 数组 👍 42 👎 0


package leetcode.editor.cn;

/**
 * K 个元素的最大和
 *
 * @author DY
 * @date 2023-11-15 18:15:20
 */
public class MaximumSumWithExactlyKElements_2656 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MaximumSumWithExactlyKElements_2656().new Solution();
        int i = solution.maximizeSum(new int[]{}, 3);
        System.out.println(i);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximizeSum(int[] nums, int k) {
            if (nums.length == 0 || k == 0) {
                return 0;
            }
            int max = findMax(nums);
            int total = 0;
            for (int i = 0; i < k; i++) {
                total += max++;
            }
            return total;
        }

        private int findMax(int[] nums) {
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                if (max < num) {
                    max = num;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}