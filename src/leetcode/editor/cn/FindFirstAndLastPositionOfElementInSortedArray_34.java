//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1829 👎 0

package leetcode.editor.cn;

/**
 * @author gary gan
 * @date 2022-08-03 17:41:54
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray_34().new Solution();
        int[] a = {};
        int target = 6;
        solution.searchRange(a, target);
    }

    class Solution2 {

    }

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ints = searchRangeMethod02(nums, target);
            return ints;
        }

        public int[] searchRangeMethod01(int[] nums, int target) {
            int start = -1;
            int end = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (start == -1) {
                        start = i;
                    }
                    end = i;
                } else if (end != -1) {
                    break;
                }
            }
            int[] resp = {start, end};
            return resp;
        }

        public int[] searchRangeMethod02(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int tempRight = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                    tempRight = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            if (right==-1 ||nums[right]!=target){
                int[] a ={-1,-1};
                return a;
            }
            int tempLeft = left;
            while (tempLeft <= tempRight) {
                int mid = tempLeft + (tempRight - tempLeft) / 2;
                if (nums[mid] == target) {
                    tempLeft = mid+1;
                } else if (nums[mid] > target) {
                    tempRight = mid - 1;
                } else if (nums[mid] <= target) {
                    tempLeft = mid + 1;
                }
            }
            int[] a = {right, tempRight};
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}