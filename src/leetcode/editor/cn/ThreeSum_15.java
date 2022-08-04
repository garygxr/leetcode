//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 5053 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gary gan
 * @date 2022-07-31 14:25:54
 */
public class ThreeSum_15 {
    public static void main(String[] args) {
        Solution solution = new ThreeSum_15().new Solution();
        int[] a = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(a);
        System.out.println(lists);
    }

    /**
     * 三数之和
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(nums);
            Integer prei = nums[0];
            for (int i = 0; i < nums.length - 2; i++) {
                if (i != 0 && prei == nums[i]) {
                    continue;
                }
                prei = nums[i];
                Integer prel = nums[i + 1];
                for (int l = i + 1; l < nums.length - 1; l++) {
                    if (l != i + 1 && prel == nums[l]) {
                        continue;
                    }
                    prel = nums[l];

                    int target = -(nums[i] + nums[l]);
                    int k = nums.length - 1;
                    while (k > l && nums[k] > target) {
                        k--;
                    }
                    if (k == l) {
                        break;
                    }

                    if (nums[k] == target) {
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[l]);
                        integers.add(nums[k]);
                        lists.add(integers);
                    }
                }
            }
            return lists;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}