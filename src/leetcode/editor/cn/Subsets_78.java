//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 1744 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gary gan
 * @date 2022-08-11 17:56:43
 */
public class Subsets_78 {
    public static void main(String[] args) {
        Solution solution = new Subsets_78().new Solution();
        int[] a = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets2(a);
        System.out.println(subsets);
    }

    /**
     * 子集
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int len;

        public List<List<Integer>> subsets(int[] nums) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            addList(lists, new ArrayList<>(), nums, 0);
            return lists;
        }

        public List<List<Integer>> subsets2(int[] nums) {
            ArrayList<List<Integer>> lists = new ArrayList<>();
            int left = 0;
            int right =0;
            while (right<nums.length){
                right++;
                addList(left,right,lists,nums);
            }
            return lists;

        }

        public void addList(List<List<Integer>> list, List<Integer> cache, int[] nums, int l) {
            if (l == nums.length) {
                list.add(new ArrayList<>(cache));
                return;
            }
            cache.add(nums[l]);
            addList(list, cache, nums, l + 1);
            cache.remove((Integer) nums[l]);
            addList(list, cache, nums, l + 1);
        }

        public void addList(int left,int right,ArrayList<List<Integer>> lists,int[] nums){
            for (int i = left; i < right; i++) {
                ArrayList<Integer> integers = new ArrayList<>();
                for (int j = i; j < right; j++) {
                    integers.add(nums[j]);
                }
                lists.add(integers);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}