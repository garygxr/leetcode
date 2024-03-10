//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2604 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 滑动窗口最大值
 *
 * @author DY
 * @date 2023-11-16 09:47:05
 */
public class SlidingWindowMaximum_239 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SlidingWindowMaximum_239().new Solution();
        int[] ints = solution.maxSlidingWindow(new int[]{1,2,3}, 0);
        System.out.println(Arrays.toString(ints));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            int maxIndex = 0;
            int left = 0;
            int right = left + k - 1;
            int resIndex = 0;
            maxIndex = findMax(nums, left, right);
            res[resIndex++] = nums[maxIndex];
            while (right < nums.length-1) {
                left++;
                right++;
                if (maxIndex < left) {
                    maxIndex = findMax(nums, left, right);
                }
                if (nums[maxIndex] < nums[right]) {
                    maxIndex = right;
                }
                res[resIndex++] = nums[maxIndex];
            }
            return res;
        }

        public int findMax(int[] nums, int left, int right) {
            int tempMaxIndex = left;
            while (left <= right) {
                if (nums[left] > nums[tempMaxIndex]) {
                    tempMaxIndex = left;
                }
                left++;
            }
            return tempMaxIndex;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}