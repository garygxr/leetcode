//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2229 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 移动零
 *
 * @author DY
 * @date 2023-11-16 09:00:31
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MoveZeroes_283().new Solution();
        int[] ints = {1, 2, 3, 0, 1, 3, 0, 3, 6};
        solution.moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0;
            int right = 0;
            while (right < nums.length - 1) {
                while (left < nums.length && nums[left] != 0) {
                    left++;
                }
                right = left;
                while (right + 1 < nums.length && nums[right] == 0) {
                    right++;
                }
                if (left != right) {
                    swap(nums, left, right);
                }
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}