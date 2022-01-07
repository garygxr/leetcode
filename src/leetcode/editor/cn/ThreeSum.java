package leetcode.editor.cn;

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
// Related Topics 数组 双指针 排序 👍 4161 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1});
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            ArrayList<List<Integer>> lists = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1, right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum == 0) {
                        List<Integer> integers = Arrays.asList(nums[i], nums[left], nums[right]);
                        lists.add(integers);

                        while (left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        while (left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else {
                        if (sum<0){
                            left++;
                        }else {
                            right--;
                        }

                    }
                }
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}